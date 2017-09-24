/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nate Cox
 */
public class SearchTest {
    
    public SearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of getSearchTerms method, of class Search.
     */
    @Test
    public void testGetSearchTerms() {
        System.out.println("getSearchTerms");
        Search instance = new Search("test", "", 0, "");
        String expResult = "test";
        String result = instance.getSearchTerms();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setSearchTerms method, of class Search.
     */
    @Test
    public void testSetSearchTerms() {
        System.out.println("setSearchTerms");
        String searchTerms = "test";
        Search instance = new Search("apple", "", 0, "");
        String intialSearchTerm = "apple";
        instance.setSearchTerms(searchTerms);
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getCompanyNameFilter method, of class Search.
     */
    @Test
    public void testGetCompanyNameFilter() {
        System.out.println("getCompanyNameFilter");
        Search instance = new Search("test", "ABC Corp", 0, "");
        String expResult = "ABC Corp";
        String result = instance.getCompanyNameFilter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDistanceFilter method, of class Search.
     */
    @Test
    public void testGetDistanceFilter() {
        System.out.println("getDistanceFilter");
        Search instance = new Search("test", "", 15, "");
        int expResult = 15;
        int result = instance.getDistanceFilter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getZipCodeFilter method, of class Search.
     */
    @Test
    public void testGetZipCodeFilter() {
        System.out.println("getZipCodeFilter");
        Search instance = new Search("test", "", 0, "16801");
        String expResult = "16801";
        String result = instance.getZipCodeFilter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
