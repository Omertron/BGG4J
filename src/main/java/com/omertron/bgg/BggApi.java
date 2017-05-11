/*
 *      Copyright (c) 2017 Stuart Boston
 *
 *      This file is part of the Board Game Geek API Wrapper.
 *
 *      This API wrapper is free software: you can redistribute it and/or modify
 *      it under the terms of the GNU General Public License as published by
 *      the Free Software Foundation, either version 3 of the License, or
 *      any later version.
 *
 *      The API wrapper is distributed in the hope that it will be useful,
 *      but WITHOUT ANY WARRANTY; without even the implied warranty of
 *      MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *      GNU General Public License for more details.
 *
 *      You should have received a copy of the GNU General Public License
 *      along with the API Wrapper.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.omertron.bgg;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.omertron.bgg.apibuilder.BggApiBuilder;
import com.omertron.bgg.enums.Command;
import com.omertron.bgg.enums.FamilyType;
import com.omertron.bgg.enums.HotItemType;
import com.omertron.bgg.enums.IncludeExclude;
import com.omertron.bgg.enums.ThingType;
import com.omertron.bgg.model.BoardGameExtended;
import com.omertron.bgg.model.BoardGameWrapper;
import com.omertron.bgg.model.CollectionItemWrapper;
import com.omertron.bgg.model.Family;
import com.omertron.bgg.model.FamilyWrapper;
import com.omertron.bgg.model.GenericListWrapper;
import com.omertron.bgg.model.HotListItem;
import com.omertron.bgg.model.SearchWrapper;
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

public class BggApi {

    private static final Logger LOG = LoggerFactory.getLogger(BggApi.class);
    private static HttpTools httpTools;
    private static XmlMapper mapper;

    /**
     * API URL base.
     */
    private static final String BASE_URL = "http://www.boardgamegeek.com/xmlapi2/{command}";
    private static final String LOG_URL = "URL: {}";

    /*
     * TODO:
     * <p>
     * Forum Lists<p>
     * Forums Threads<p>
     * Guilds<p>
     *
     */
    /**
     * BoardGameGeek API wrapper.
     *
     * This method will use a default HttpClient
     */
    public BggApi() {
        this(new SimpleHttpClientBuilder().build());
    }

    /**
     * BoardGameGeek API wrapper.
     *
     * @param httpClient Use the supplied HttpClient for web access
     */
    public BggApi(HttpClient httpClient) {
        httpTools = new HttpTools(httpClient);
        mapper = new XmlMapper();
    }

    /**
     * Get information on a board game
     *
     * @param id The BGG ID number
     * @return List of boardgames that match the supplied ID
     * @throws BggException Custom exception containing failure code
     */
    public List<BoardGameExtended> getBoardGameInfo(int id) throws BggException {
        List<IncludeExclude> includes = new ArrayList<>();
        includes.add(IncludeExclude.STATS);
        includes.add(IncludeExclude.VERSIONS);
        includes.add(IncludeExclude.VIDEOS);

        return getBoardGameInfo(ThingType.BOARDGAME, id, includes, null);
    }

    /**
     * Get information on a "thing" (board game, expansions or accessories)
     *
     * @param type The type of the "thing" to get information about
     * @param id The ID of the thing
     * @param includes List of additional information to include
     * @param excludes List of items to Exclude from the query
     * @return List of boardgames that match the query
     * @throws BggException Custom exception containing failure code
     */
    public List<BoardGameExtended> getBoardGameInfo(ThingType type, int id, List<IncludeExclude> includes, List<IncludeExclude> excludes) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.THING)
                .id(id)
                .thingType(type)
                .include(includes)
                .exclude(excludes)
                .page(1)
                .pageSize(25)
                .buildUrl();

        BoardGameWrapper wrapper;
        try {
            LOG.debug(LOG_URL, url);
            String webpage = httpTools.retrieveWebpage(url);
            wrapper = mapper.readValue(webpage, BoardGameWrapper.class);
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map to BoardGameList", url, ex);
        }

        if (wrapper.getItems() != null) {
            return wrapper.getItems();
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * Get the family information on a particular family
     *
     * @param id The BGG ID for the family item
     * @param familyType The type of family item to get
     * @return List of the family items
     * @throws BggException Custom exception containing failure code
     */
    public List<Family> getFamilyItems(int id, FamilyType familyType) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.FAMILY)
                .family(familyType)
                .id(id)
                .buildUrl();

        LOG.debug(LOG_URL, url);

        try {
            String webpage = httpTools.retrieveWebpage(url);
            FamilyWrapper familyWrapper = mapper.readValue(webpage, FamilyWrapper.class);
            return familyWrapper.getItems();
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map to Family", url, ex);
        }
    }

    /**
     * Get information on a user
     *
     * @param username The username of the person to retrieve information on
     * @return Information on the user
     * @throws BggException Custom exception containing failure code
     */
    public UserInfo getUserInfo(String username) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.USER)
                .name(username)
                .include(IncludeExclude.BUDDIES,
                        IncludeExclude.GUILDS,
                        IncludeExclude.HOT,
                        IncludeExclude.TOP)
                .buildUrl();

        LOG.debug(LOG_URL, url);

        try {
            String webpage = httpTools.retrieveWebpage(url);
            return mapper.readValue(webpage, UserInfo.class);
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map UserInfo", url, ex);
        }
    }

    /**
     * Get information on a users collection
     *
     * @param username The user to get the collection of
     * @param id Get information on a specific game, can be null or zero
     * @param include Flags to include items in the search
     * @param exclude Flags to exclude items in the search
     * @param includeExpansions
     * @return A wrapper class with the list of collection items
     * @throws BggException Custom exception containing failure code
     */
    public CollectionItemWrapper getCollectionInfo(String username,
            String id,
            List<IncludeExclude> include,
            List<IncludeExclude> exclude,
            boolean includeExpansions) throws BggException {
        BggApiBuilder builder = new BggApiBuilder(BASE_URL)
                .command(Command.COLLECTION)
                .username(username)
                .id(id)
                // Add the includes 
                .include(include)
                // Add the excludes
                .exclude(exclude);

        if (!includeExpansions) {
            builder.subType(ThingType.BOARDGAMEEXPANSION);
        }

        URL url = builder.buildUrl();

        LOG.debug(LOG_URL, url);

        String webpage = httpTools.retrieveWebpage(url);
        try {
            return mapper.readValue(webpage, CollectionItemWrapper.class);
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map CollectionInfo", url, ex);
        }

    }

    /**
     * Search BGG for the game name
     *
     * @param query The item query to search for
     * @param exact Search for the exact query
     * @param includeExpansions Include expansions in the search
     * @return A wrapper class with the search responses
     * @throws BggException Custom exception containing failure code
     */
    public SearchWrapper searchBoardGame(String query, boolean exact, boolean includeExpansions) throws BggException {
        BggApiBuilder builder = new BggApiBuilder(BASE_URL)
                .command(Command.SEARCH)
                .query(query)
                .thingType(ThingType.BOARDGAME);

        if (includeExpansions) {
            builder = builder.thingType(ThingType.BOARDGAME, ThingType.BOARDGAMEEXPANSION);
        } else {
            builder = builder.thingType(ThingType.BOARDGAME);
        }

        if (exact) {
            builder = builder.include(IncludeExclude.EXACT);
        }

        URL url = builder.buildUrl();
        LOG.debug(LOG_URL, url);

        String webpage = httpTools.retrieveWebpage(url);
        try {
            return mapper.readValue(webpage, SearchWrapper.class);
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map CollectionInfo", url, ex);
        }

    }

    /**
     * You can retrieve the list of most active items on the site.
     *
     * @param itemType The Item type to get the hot list for.
     * @return The list of items for the Hot List
     * @throws BggException Custom exception containing failure code
     */
    public List<HotListItem> getHotItems(HotItemType itemType) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.HOT)
                .hotType(itemType == null ? HotItemType.BOARDGAME : itemType)
                .buildUrl();
        LOG.debug(LOG_URL, url);

        String webpage = httpTools.retrieveWebpage(url);
        try {
            TypeReference tr = new TypeReference<GenericListWrapper<HotListItem>>() {
            };
            GenericListWrapper<HotListItem> results = mapper.readValue(webpage, tr);
            return results.getItems();
        } catch (IOException ex) {
            throw new BggException(ApiExceptionType.MAPPING_FAILED, "Failed to map Hot List information", url, ex);
        }
    }

    public void getPlays(String username, int bggId, Command type, String minDate, String maxDate, ThingType subtype, int page) throws BggException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.PLAYS)
                .buildUrl();
        LOG.debug(LOG_URL, url);

        String webpage = httpTools.retrieveWebpage(url);
    }
}
