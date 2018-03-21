/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import integration.InspectionDTO;
import model.QueueNumber;

/**
 *
 * @author tmp-sda-1160
 */
public class InspectionControllerTest {

    private InspectionController instance;
    private QueueNumber queueNo;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

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
        queueNo = new QueueNumber();
        instance = new InspectionController(queueNo);
    }

    @After
    public void tearDown() {
    }

    /**
     * set up stream to test print statement
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    /**
     * Test of displayNo method, of class InspectionController.
     */
    @Test
    public void testDisplayNo() {
        instance.displayNo();
        String expected = "The display is now showing: 1";
        String actual = outContent.toString();

        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
    }

    /**
     * Test of openGarageDoor method, of class InspectionController.
     */
    @Test
    public void testOpenGarageDoor() {
        System.out.println("openGarageDoor");
        instance.openGarageDoor();
        String expected = "The door is open";
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
    }

    /**
     * Test of closeGarageDoor method, of class InspectionController.
     */
    @Test
    public void testCloseGarageDoor() {
        instance.closeGarageDoor();
        String expected = "The door is closed";
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);

    }

    /**
     * Test of verifyRegistrationNo method, of class InspectionController.
     */
    @Test
    public void testVerifyValidRegistrationNo() {

        String regNo = "1001";
        boolean expResult = true;
        boolean result = instance.verifyRegistrationNo(regNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of verifyRegistrationNo method, of class InspectionController.
     */
    @Test
    public void testVerifyInValidRegistrationNo() {

        String regNo = "k1001";
        boolean expResult = false;
        boolean result = instance.verifyRegistrationNo(regNo);
        assertEquals(expResult, result);
    }

    /**
     * Test of fetchInspectionList method, of class InspectionController.
     */
    @Test
    public void testFetchInspectionList() {

        String regNo = "1005";
        ArrayList<InspectionDTO> expectedInspectionList = new ArrayList<InspectionDTO>();
        ArrayList<InspectionDTO> result = instance.fetchInspectionList(regNo);
        expectedInspectionList.add(new InspectionDTO("Driver Seat Function", 550.0, false));
        expectedInspectionList.add(new InspectionDTO("Mirror Functions", 300.0, false));
        expectedInspectionList.add(new InspectionDTO("Central locking functions", 250.0, false));
        expectedInspectionList.add(new InspectionDTO("Navigation System", 450.0, false));
        assertNotNull(result);
        assertEquals(expectedInspectionList.get(1).getInspectionValue(), result.get(1).getInspectionValue());
    }

    /**
     * Test of saveInspectionResult method, of class InspectionController.
     */
    @Test
    public void testSaveInspectionResult() {
        System.out.println("saveInspectionResult");
        String regNo = "1001";
        ArrayList<InspectionDTO> inspectionResult = new ArrayList<InspectionDTO>();
        inspectionResult.add(new InspectionDTO("Driver Seat Function", 200, false));
        inspectionResult.add(new InspectionDTO("Mirror Functions", 300, true));
        inspectionResult.add(new InspectionDTO("Navigation System", 500, true));

        instance.saveInspectionResult(regNo, inspectionResult);
        String expected = regNo;
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
    }

    /**
     * Test of savePayment method, of class InspectionController.
     */
    @Test
    public void testSavePayment() {
        System.out.println("savePayment");
        String regNo = "1001";
        double cost = 1000.0;
        String expected = "Payment Saved Sucessfully!!!!!";
        instance.savePayment(regNo, cost);
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
    }

    /**
     * Test of calculateCost method, of class InspectionController.
     */
    @Test
    public void testCalculateCost() {

        double expResult = 1000.0;
        ArrayList<InspectionDTO> inspectionList = new ArrayList<InspectionDTO>();
        inspectionList.add(new InspectionDTO("Driver Seat Function", 200, false));
        inspectionList.add(new InspectionDTO("Mirror Functions", 300, true));
        inspectionList.add(new InspectionDTO("Navigation System", 500, true));

        double result = instance.calculateCost(inspectionList);
        assertEquals(expResult, result, 0.0);
    }

}
