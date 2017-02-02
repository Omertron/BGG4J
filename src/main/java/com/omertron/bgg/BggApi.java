package com.omertron.bgg;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.omertron.bgg.apibuilder.BggApiBuilder;
import com.omertron.bgg.enums.Command;
import com.omertron.bgg.enums.FamilyType;
import com.omertron.bgg.enums.IncludeExclude;
import com.omertron.bgg.enums.ThingType;
import com.omertron.bgg.model.BoardGameExtended;
import com.omertron.bgg.model.BoardGameWrapper;
import com.omertron.bgg.model.CollectionItemWrapper;
import com.omertron.bgg.model.Family;
import com.omertron.bgg.model.FamilyWrapper;
import com.omertron.bgg.model.UserInfo;
import com.omertron.bgg.tools.HttpTools;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.exception.ApiExceptionType;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

/**
 *
 * @author Omertron
 */
public class BggApi {

    private static final Logger LOG = LoggerFactory.getLogger(BggApi.class);
    private static HttpTools httpTools;
    private static XmlMapper mapper;
    private static final String TRY_AGAIN = "Please try again later for access";
    private static final int MAX_RETRY = 5;
    private static final int DELAY = 1000;

    /**
     * API URL base.
     */
    private static final String BASE_URL = "http://www.boardgamegeek.com/xmlapi2/{command}";

    public BggApi() {
        this(new SimpleHttpClientBuilder().build());
    }

    public BggApi(HttpClient httpClient) {
        httpTools = new HttpTools(httpClient);
        mapper = new XmlMapper();
    }

    public List<BoardGameExtended> getBoardGameInfo(int id) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.THING)
                .id(id)
                .thingType(ThingType.BOARDGAME)
                .include(IncludeExclude.VERSIONS,
                        IncludeExclude.VIDEOS,
                        IncludeExclude.STATS,
                        IncludeExclude.HISTORICAL,
                        IncludeExclude.MARKETPLACE,
                        IncludeExclude.COMMENTS,
                        IncludeExclude.RATINGCOMMENTS)
                .page(1)
                .pageSize(25)
                .buildUrl();

        BoardGameWrapper bgl;
        try {
            LOG.info("URL: {}", url);
            String webpage = retrieveWebpage(url);
            bgl = mapper.readValue(webpage, BoardGameWrapper.class);
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map to BoardGameList", url, ex);
        }

        if (bgl.getItems() != null) {
            return bgl.getItems();
        } else {
            return new ArrayList<>();
        }
    }

    public List<Family> getFamilyItems(int id, FamilyType familyType) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.FAMILY)
                .family(familyType)
                .id(id)
                .buildUrl();

        LOG.info("URL: {}", url);

        try {
            String webpage = retrieveWebpage(url);
            FamilyWrapper familyWrapper = mapper.readValue(webpage, FamilyWrapper.class);
            return familyWrapper.getItems();
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map to Family", url, ex);
        }
    }

    public UserInfo getUserInfo(String name) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.USER)
                .name(name)
                .include(IncludeExclude.BUDDIES,
                        IncludeExclude.GUILDS,
                        IncludeExclude.HOT,
                        IncludeExclude.TOP)
                .buildUrl();

        LOG.info("URL: {}", url);

        try {
            String webpage = retrieveWebpage(url);
            return mapper.readValue(webpage, UserInfo.class);
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map UserInfo", url, ex);
        }
    }

    /**
     * Get information on a users collection
     *
     * @param username
     * @param include
     * @param exclude
     * @return
     * @throws BggException
     */
    public CollectionItemWrapper getCollectionInfo(String username, List<IncludeExclude> include, List<IncludeExclude> exclude) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.COLLECTION)
                .username(username)
                // Add the includes 
                .include(include)
                // Add the excludes
                .exclude(exclude)
                .buildUrl();

        LOG.info("URL: {}", url);

        String webpage = retrieveWebpage(url);
        try {
            return mapper.readValue(webpage, CollectionItemWrapper.class);
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map CollectionInfo", url, ex);
        }

    }

    /**
     * Get the web data from BGG, allowing for the retry time
     *
     * @param response
     * @return
     */
    private String retrieveWebpage(URL url) throws BggException {
        String webpage = httpTools.getRequest(url);
        int retryCount = 1;

        while (webpage.contains(TRY_AGAIN) && retryCount <= MAX_RETRY) {
            delay(retryCount++ * DELAY);
            webpage = httpTools.getRequest(url);
        }

        if (!webpage.contains(TRY_AGAIN)) {
            return webpage;
        }

        throw new BggException(ApiExceptionType.CONNECTION_ERROR, "Exceeded retry count");
    }

    /**
     * Create a delay
     *
     * @param delay
     */
    private void delay(long delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException ex) {
            LOG.trace("Sleep interrupted", ex);
        }
    }
}
