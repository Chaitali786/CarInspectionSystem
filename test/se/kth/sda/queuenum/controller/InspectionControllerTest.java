/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.controller;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import se.kth.sda.queuenum.integration.CreditCard;
import se.kth.sda.queuenum.integration.Inspection;

/**
 *
 * @author tmp-sda-1160
 */
public class InspectionControllerTest {
    
    public InspectionControllerTest() {
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
     * Test of displayNo method, of class InspectionController.
     */
    @Ignore
    public void testDisplayNo() {
        System.out.println("displayNo");
        InspectionController instance = null;
        instance.displayNo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openGarageDoor method, of class InspectionController.
     */
    @Ignore
    public void testOpenGarageDoor() {
        System.out.println("openGarageDoor");
        InspectionController instance = null;
        instance.openGarageDoor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of closeGarageDoor method, of class InspectionController.
     */
    @Ignore
    public void testCloseGarageDoor() {
        System.out.println("closeGarageDoor");
        InspectionController instance = null;
        instance.closeGarageDoor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verifyRegistrationNo method, of class InspectionController.
     */
    @Ignore
    public void testVerifyRegistrationNo() {
        System.out.println("verifyRegistrationNo");
        String regNo = "";
        InspectionController instance = null;
        boolean expResult = false;
        boolean result = instance.verifyRegistrationNo(regNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fetchInspectionList method, of class InspectionController.
     */
    @Ignore
    public void testFetchInspectionList() {
        System.out.println("fetchInspectionList");
        String regNo = "";
        InspectionController instance = null;
        ArrayList<Inspection> expResult = null;
        ArrayList<Inspection> result = instance.fetchInspectionList(regNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveInspectionResult method, of class InspectionController.
     */
    @Ignore
    public void testSaveInspectionResult() {
        System.out.println("saveInspectionResult");
        String regNo = "";
        ArrayList<Inspection> inspectionResult = null;
        InspectionController instance = null;
        instance.saveInspectionResult(regNo, inspectionResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makePayment method, of class InspectionController.
     */
    @Ignore
    public void testMakePayment_3args_1() {
        System.out.println("makePayment");
        String regNo = "";
        CreditCard cardDetail = null;
        double cost = 0.0;
        InspectionController instance = null;
        instance.makePayment(regNo, cardDetail, cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makePayment method, of class InspectionController.
     */
   @Ignore
    public void testMakePayment_3args_2() {
        System.out.println("makePayment");
        String regNo = "";
        double cashPaid = 0.0;
        double cost = 0.0;
        InspectionController instance = null;
        double expResult = 0.0;
        double result = instance.makePayment(regNo, cashPaid, cost);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePayment method, of class InspectionController.
     */
    @Ignore
    public void testSavePayment() {
        System.out.println("savePayment");
        String regNo = "";
        double cost = 0.0;
        InspectionController instance = null;
        instance.savePayment(regNo, cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCost method, of class InspectionController.
     */
    @Ignore
    public void testCalculateCost() {
        System.out.println("calculateCost");
        ArrayList<Inspection> inspectionList = null;
        InspectionController instance = null;
        double expResult = 0.0;
        double result = instance.calculateCost(inspectionList);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
