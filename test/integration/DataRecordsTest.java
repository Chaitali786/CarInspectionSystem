/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.integration;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;


/**
 *
 * @author OODGroup
 */
public class DataRecordsTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    DataRecords db; 
    public DataRecordsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         db = new DataRecords();
    	//boolean result=false ;
         db.makeRegNumInspectionList();
    }
    
    @After
    public void tearDown() {
    }
    @Before
    public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    //System.setErr(new PrintStream(errContent));
}

    @After
    public void restoreStreams() {
    System.setOut(System.out);
    
}

    /**
     * Test of makeInspectionTaskArrayList method, of class DataRecords.
     */
    @Test
    public void testMakeInspectionTaskArrayList() {
        DataRecords databaseObj = new DataRecords();
        System.out.println("Test Case For : makeInspectionTaskArrayList() ");
       
        ArrayList<Inspection> expResult = new ArrayList<Inspection>() ;
        ArrayList<Inspection> result = null;
              
        Inspection inspection = new Inspection("Driver Seat Function", 200, false);
        expResult.add(inspection);
        result=databaseObj.makeInspectionTaskArrayList(inspection);
        assertEquals(expResult, result);
    }

    /**
     * Test of makeRegNumInspectionList method, of class DataRecords.
     */
    @Test
    public void testMakeRegNumInspectionList() {
        DataRecords databaseObj = new DataRecords();
        System.out.println("Test Case For : makeRegNumInspectionList() ");
        databaseObj.makeRegNumInspectionList();
        String expected = "Data Records Are Available  !!!";
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
             
    }

    /**
     * Test of verifyRegistrationNo method, of class DataRecords.
     */
    @Test
    public void testVerifyRegistrationNo() {
        {
    	
    	db.makeRegNumInspectionList();
    	assertEquals(true,db.verifyRegistrationNo("1010"));
		//fail("Not yet implemented");
}
    }

    /**
     * Test of fetchInspectionList method, of class DataRecords.
     */
    @Test
    public void testFetchInspectionList() {
        ArrayList<Inspection> tempArrayList = new ArrayList<Inspection>();
        ArrayList<Inspection> tempArrayListfromdb =  new ArrayList<Inspection>();
    	tempArrayListfromdb=db.fetchInspectionList("1005");
    	tempArrayList.add(new Inspection("Driver Seat Function",550,false));
    	tempArrayList.add(new Inspection("Mirror Functions",300,false));
    	tempArrayList.add(new Inspection("Central locking functions",250,false));
    	tempArrayList.add(new Inspection("Navigation System",450,false));
       	assertNotNull(tempArrayListfromdb);
        assertEquals(tempArrayList.get(0).getInspectionValue(), tempArrayListfromdb.get(0).getInspectionValue());
    }

   

    /**
     * Test of saveInspectionResult method, of class DataRecords.
     */
    @Test
    public void testSaveInspectionResult() {
        System.out.println("saveInspectionResult");
        String regNo = "1001";
        ArrayList<Inspection> inspectionResult = new ArrayList<Inspection>();
        inspectionResult.add(new Inspection("Driver Seat Function", 200, false));
        inspectionResult.add(new Inspection("Mirror Functions", 300, true));
        inspectionResult.add(new Inspection("Navigation System", 500, true));
   
        db.saveInspectionResult(regNo, inspectionResult);
        String expected = "Inspection Done !!!";
        String actual   =  outContent.toString();
        boolean isExist =  actual.contains(expected);
        assertTrue(isExist);
    }

    /**
     * Test of displaySaveInspectionResult method, of class DataRecords.
     */
    @Test
    public void testDisplaySaveInspectionResult() {
        System.out.println("displaySaveInspectionResult");
        String regNo ="1005" ;
        db.displaySaveInspectionResult(regNo);
        String expected = " Registration Number :";
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of savePayment method, of class DataRecords.
     */
    @Test
    public void testSavePayment() {
        System.out.println("savePayment");
        String regNo ="1001" ;
        double costpaid=1000.0;
        db.savePayment(regNo,costpaid);
        String expected = "Payment Saved Sucessfully!!!!!";
        String actual = outContent.toString();
        boolean isExist = actual.contains(expected);
        assertTrue(isExist);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
 }
