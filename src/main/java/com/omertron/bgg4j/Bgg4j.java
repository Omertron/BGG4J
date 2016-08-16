package com.omertron.bgg4j;

import com.omertron.bgg4j.apibuilder.BggApiBuilder;
import com.omertron.bgg4j.enums.Command;
import com.omertron.bgg4j.enums.ThingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Omertron
 */
public class Bgg4j {

    private static final Logger LOG = LoggerFactory.getLogger(Bgg4j.class);

    /**
     * API URL base.
     */
    private static final String BASE_URL = "http://www.boardgamegeek.com/xmlapi2/{command}";

//193037 DOW:TLN
    public void test() {
        String out = new BggApiBuilder(BASE_URL)
                .command(Command.thing)
                .id(193037)
                .thingType(ThingType.boardgame)
                .buildUrl(true);

        LOG.info("URL: {}", out);
    }
}
