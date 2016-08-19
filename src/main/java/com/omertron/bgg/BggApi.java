package com.omertron.bgg;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.omertron.bgg.apibuilder.BggApiBuilder;
import com.omertron.bgg.enums.Command;
import com.omertron.bgg.enums.ThingType;
import com.omertron.bgg.model.BoardGameList;
import com.omertron.bgg.tools.HttpTools;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yamj.api.common.http.SimpleHttpClientBuilder;

/**
 *
 * @author Omertron
 */
public class BggApi {

    private static final Logger LOG = LoggerFactory.getLogger(BggApi.class);
    private static HttpTools httpTools;
    private static XmlMapper mapper;

    /**
     * API URL base.
     */
    private static final String BASE_URL = "http://www.boardgamegeek.com/xmlapi2/{command}";

    public BggApi() {
        httpTools = new HttpTools(new SimpleHttpClientBuilder().build());
        mapper = new XmlMapper();
    }

//193037 DOW:TLN
    public void xmlTest(int id) throws BggException, IOException {
        URL url = new BggApiBuilder(BASE_URL)
                .command(Command.THING)
                .id(id)
                .thingType(ThingType.BOARDGAME)
                .versions(1)
                .videos(1)
                .stats(1)
                .historical(1)
                .marketplace(1)
                .comments(1)
                .ratingComments(1)
                .page(1)
                .pageSize(25)
                .buildUrl();

        LOG.info("URL: {}", url);

        File src = new File("SampleData.xml");
        LOG.info("Filename: " + src.getAbsolutePath());
//        String webpage = httpTools.getRequest(url);
//        BoardGameList bgl = mapper.readValue(webpage, BoardGameList.class);
        BoardGameList bgl = mapper.readValue(src, BoardGameList.class);
        
//        for (BoardGame bg : bgl.getItems()) {
//            LOG.info("{}", ToStringBuilder.reflectionToString(bg, ToStringStyle.MULTI_LINE_STYLE));
//        }
    }
}
