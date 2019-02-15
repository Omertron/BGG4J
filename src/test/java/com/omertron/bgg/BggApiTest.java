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

import com.omertron.bgg.enums.FamilyType;
import com.omertron.bgg.enums.HotItemType;
import com.omertron.bgg.enums.IncludeExclude;
import com.omertron.bgg.model.BoardGameExtended;
import com.omertron.bgg.model.CollectionItem;
import com.omertron.bgg.model.CollectionItemWrapper;
import com.omertron.bgg.model.Family;
import com.omertron.bgg.model.HotListItem;
import com.omertron.bgg.model.SearchWrapper;
import com.omertron.bgg.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Omertron
 */
public class BggApiTest {

    private static final Logger LOG = LoggerFactory.getLogger(BggApiTest.class);
    private final BggApi bggApi;

    private static final List<TestValue> USERNAMES = new ArrayList<>();
    private static final List<TestValue> GAME_IDS = new ArrayList<>();
    private static final List<TestValue> FAMILY_IDS = new ArrayList<>();

    public BggApiTest() {
        bggApi = new BggApi();
    }

    @BeforeClass
    public static void setUpClass() {
        TestLogger.configure();
        TestValue tv = new TestValue("omertron", 1170953);
        USERNAMES.add(tv);
        tv = new TestValue("chaddyboy_2000", 4994);
        tv.addIgnore("MEMORY");
        tv.addIgnore("hot");
        USERNAMES.add(tv);

        tv = new TestValue("Dlthorpe", 685930);
        tv.addIgnore("hot");
        tv.addIgnore("top");
        USERNAMES.add(tv);

        GAME_IDS.add(new TestValue(193037));    // Dead of Winter
        GAME_IDS.add(new TestValue(161886));    // 1879

        // Ticket To Ride
        FAMILY_IDS.add(new TestValue(17));
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getBoardGameInfo method, of class BggApi.
     *
     * @throws BggException Custom exception containing failure code
     */
    @Test
    public void testGetBoardGameInfo() throws BggException {
        LOG.info("getBoardGameInfo");

        for (TestValue test : GAME_IDS) {
            LOG.info("Testing: {}", test.toString());
            List<BoardGameExtended> result = bggApi.getBoardGameInfo(test.getId());

            for (BoardGameExtended bg : result) {
                assertTrue("No max players", bg.getMaxPlayers() > 0);

                // Skip these for the "1879" game
                if (test.getId() != 161886) {
                    assertFalse("No Alt Names", bg.getAlternativeNames().isEmpty());
                    assertFalse("No Artists", bg.getBoardGameArtist().isEmpty());
                    assertFalse("No Expansions", bg.getBoardGameExpansion().isEmpty());
                    assertFalse("No Integration", bg.getBoardGameIntegration().isEmpty());
                }
                assertFalse("No Categories", bg.getBoardGameCategory().isEmpty());
                assertFalse("No Designers", bg.getBoardGameDesigner().isEmpty());
                assertFalse("No Family", bg.getBoardGameFamily().isEmpty());
                assertFalse("No Mechanic", bg.getBoardGameMechanic().isEmpty());
                assertFalse("No Publishers", bg.getBoardGamePublisher().isEmpty());
            }
        }
    }

    /**
     * Test of getFamilyItems method, of class BggApi.
     *
     * @throws BggException Custom exception containing failure code
     */
    @Test
    public void testGetFamilyItems() throws BggException {
        LOG.info("getFamilyItems");

        for (TestValue test : FAMILY_IDS) {
            LOG.info("{}", test.toString());
            List<Family> result = bggApi.getFamilyItems(test.getId(), FamilyType.BOARDGAMEFAMILY);

            for (Family f : result) {
                assertTrue("No Description", StringUtils.isNotBlank(f.getDescription()));
                assertFalse("No links", f.getLinks().isEmpty());
            }
        }
    }

    /**
     * Test of getUserInfo method, of class BggApi.
     *
     * @throws BggException Custom exception containing failure code
     */
    @Test
    public void testGetUserInfo() throws BggException {
        LOG.info("getUserInfo");

        for (TestValue test : USERNAMES) {
            LOG.info("{}", test.toString());
            UserInfo result = bggApi.getUserInfo(test.getUsername());

            assertEquals("Wrong ID", result.getId(), test.getId().intValue());
            assertTrue("No avatar", StringUtils.isNotBlank(result.getAvatarLink()));
            assertFalse("No Buddies", result.getBuddies().isEmpty());
            assertFalse("No Guilds", result.getGuilds().isEmpty());
            if (test.containsIgnore("top")) {
                LOG.debug("Skipped TOP list for {}", test.getUsername());
            } else {
                assertFalse("No Top list for " + test.getUsername(), result.getTopList().isEmpty());
            }
            if (test.containsIgnore("hot")) {
                LOG.debug("Skipped HOT list for {}", test.getUsername());
            } else {
                assertFalse("No Hot list for " + test.getUsername(), result.getHotList().isEmpty());
            }
        }
    }

    @Test
    public void testGetCollectionId() throws BggException {
        LOG.info("getCollectionInfo with ID");

        List<IncludeExclude> includes = new ArrayList<>();
        List<IncludeExclude> excludes = new ArrayList<>();

        includes.add(IncludeExclude.STATS);

        CollectionItemWrapper result = bggApi.getCollectionInfo("omertron", "124361,142451,159675", includes, excludes, false);

        LOG.info("Found {} results", result.getTotalItems());

        assertNotNull("Null items", result.getItems());
        assertFalse("Empty items", result.getItems().isEmpty());

        for (CollectionItem item : result.getItems()) {
            assertNotNull("Null collection item", item);
        }

    }

    /**
     * Test of getCollectionInfo method, of class BggApi.
     *
     * @throws BggException Custom exception containing failure code
     */
    @Test
    public void testGetCollectionInfo() throws BggException {
        LOG.info("getCollectionInfo");

        for (TestValue test : USERNAMES) {
            LOG.info("{}", test.toString());
            List<IncludeExclude> includes = new ArrayList<>();
            List<IncludeExclude> excludes = new ArrayList<>();

            includes.add(IncludeExclude.OWN);
            includes.add(IncludeExclude.COMMENT);

            if (test.containsIgnore("MEMORY")) {
                LOG.info("Stats, Rated and version skipped due to memory issues");
            } else {
                includes.add(IncludeExclude.STATS);
                includes.add(IncludeExclude.RATED);
                includes.add(IncludeExclude.VERSION);
            }

            // Get collection with no expansions
            CollectionItemWrapper result = bggApi.getCollectionInfo(test.getUsername(), "", includes, excludes, false);

            assertTrue("No collection found", result.getTotalItems() > 0);
            assertNotNull("Empty collection", result.getItems());
            assertFalse("No collection items found", result.getItems().isEmpty());
        }
    }

    /**
     * Test of getCollectionInfo method, of class BggApi.
     *
     * @throws BggException Custom exception containing failure code
     */
    @Test
    public void testGetCollectionInfoExpansions() throws BggException {
        LOG.info("getCollectionInfo - Expansions");

        List<IncludeExclude> includes = new ArrayList<>();
        List<IncludeExclude> excludes = new ArrayList<>();

        includes.add(IncludeExclude.OWN);

        for (TestValue test : USERNAMES) {
            if ("omertron".equalsIgnoreCase(test.getUsername())) {
                LOG.info("{}", test.toString());
            } else {
                LOG.info("Skipping: {}", test.getUsername());
                continue;
            }
            // Get collection with NO expansions
            CollectionItemWrapper result = bggApi.getCollectionInfo(test.getUsername(), "", includes, excludes, false);
            int noExpSize = result.getTotalItems();

            // Get collection WITH expansions
            result = bggApi.getCollectionInfo(test.getUsername(), "", includes, excludes, true);

            LOG.info("No Expansions: {}, With Expansions: {}", noExpSize, result.getTotalItems());

            assertTrue("Same collection size! Should have more with expansions", noExpSize < result.getTotalItems());
        }
    }

    /**
     * Test of searchBoardGame method, of class BggApi.
     *
     * @throws BggException Custom exception containing failure code
     */
    @Test
    public void testSearchBoardGame() throws BggException {
        LOG.info("searchBoardGame");
        String query = "Sushi Go";
        SearchWrapper result = bggApi.searchBoardGame(query, false, true);

        assertTrue("Not enough search results", result.getTotal() >= 4);
        assertNotNull("No results!", result.getItems());
        assertFalse("No result items", result.getItems().isEmpty());
    }

    /**
     * Test of getHotItems method, of class BggApi.
     *
     * @throws BggException Custom exception containing failure code
     */
    @Test
    public void testGetHotItems() throws BggException {
        LOG.info("getHotItems");

        for (HotItemType itemType : HotItemType.values()) {
            if (itemType == HotItemType.RPGPERSON || itemType == HotItemType.VIDEOGAMECOMPANY) {
                continue;
            }

            List<HotListItem> result = bggApi.getHotItems(itemType);
            assertNotNull("Null items returned for " + itemType.toString(), result);
            assertFalse("No items returned for " + itemType.toString(), result.isEmpty());
        }
    }
}
