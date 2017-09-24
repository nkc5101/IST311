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
public class FilterTest {
    
    public FilterTest() {
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
     * Test of getCompanyName method, of class Filter.
     */
    @Test
    public void testGetCompanyName() {
        System.out.println("getCompanyName");
        Filter instance = new Filter("ABC Corp", 0, "");
        String expResult = "ABC Corp";
        String result = instance.getCompanyName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCompanyName method, of class Filter.
     */
    @Test
    public void testSetCompanyName() {
        System.out.println("setCompanyName");
        String companyName = "ABC Corp";
        Filter instance = new Filter("test", 0, "");
        instance.setCompanyName(companyName);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDistance method, of class Filter.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Filter instance = new Filter("", 1, "");
        int expResult = 1;
        int result = instance.getDistance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDistance method, of class Filter.
     */
    @Test
    public void testSetDistance() {
        System.out.println("setDistance");
        int distance = 2;
        Filter instance = new Filter("", 0, "");
        instance.setDistance(distance);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getZipCode method, of class Filter.
     */
    @Test
    public void testGetZipCode() {
        System.out.println("getZipCode");
        Filter instance = new Filter("", 0, "16801");
        String expResult = "16801";
        String result = instance.getZipCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setZipCode method, of class Filter.
     */
    @Test
    public void testSetZipCode() {
        System.out.println("setZipCode");
        String zipCode = "16801";
        Filter instance = new Filter("", 0, "");
        instance.setZipCode(zipCode);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
