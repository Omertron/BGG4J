/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.omertron.bgg;

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
     * Test of xmlTest method, of class BggApi.
     * @throws java.lang.Exception
     */
    @Test
    public void testXmlTest() throws Exception {
        LOG.info("xmlTest");
        int id = 193037;
        bggApi.xmlTest(id);
    }
}
