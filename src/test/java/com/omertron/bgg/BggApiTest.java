package com.omertron.bgg;

import com.omertron.bgg.enums.FamilyType;
import com.omertron.bgg.enums.IncludeExclude;
import com.omertron.bgg.model.BoardGameExtended;
import com.omertron.bgg.model.Family;
import com.omertron.bgg.model.UserInfo;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.After;
import org.junit.AfterClass;
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

    protected static final Logger LOG = LoggerFactory.getLogger(BggApiTest.class);
    private final BggApi bggApi;

    public BggApiTest() {
        bggApi = new BggApi();
    }

    @BeforeClass
    public static void setUpClass() {
        TestLogger.configure();
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
     * @throws com.omertron.bgg.BggException
     */
//    @Test
    public void testGetBoardGameInfo() throws BggException {
        LOG.info("getBoardGameInfo");
        int id = 193037; //193037 DOW:TLN

        List<BoardGameExtended> result = bggApi.getBoardGameInfo(id);

        for (BoardGameExtended bg : result) {
            LOG.info("{}", ToStringBuilder.reflectionToString(bg, ToStringStyle.MULTI_LINE_STYLE));
        }
    }

    /**
     * Test of getFamilyItems method, of class BggApi.
     *
     * @throws com.omertron.bgg.BggException
     */
//    @Test
    public void testGetFamilyItems() throws BggException {
        LOG.info("getFamilyItems");
        int id = 17; // Ticket To Ride
        List<Family> result = bggApi.getFamilyItems(id, FamilyType.BOARDGAMEFAMILY);

        for (Family f : result) {
            LOG.info("{}", f);
            LOG.info("Links: {}", f.getLinks().size());
        }
    }

    /**
     * Test of getUserInfo method, of class BggApi.
     *
     * @throws com.omertron.bgg.BggException
     */
//    @Test
    public void testGetUserInfo() throws BggException {
        LOG.info("getUserInfo");
        String name = "chaddyboy_2000";
        UserInfo result = bggApi.getUserInfo(name);
        LOG.info("{}", ToStringBuilder.reflectionToString(result, ToStringStyle.MULTI_LINE_STYLE));
    }

    /**
     * Test of getCollectionInfo method, of class BggApi.
     *
     * @throws com.omertron.bgg.BggException
     */
    @Test
    public void testGetCollectionInfo() throws BggException {
        LOG.info("getCollectionInfo");
//        String username = "chaddyboy_2000";
        String username = "omertron";
        List<IncludeExclude> include = new ArrayList<>();
        List<IncludeExclude> exclude = new ArrayList<>();

        include.add(IncludeExclude.OWN);
        bggApi.getCollectionInfo(username, include, exclude);
    }

}
