/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.integration;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author tmp-sda-1160
 */
public class DataRecordsTest {
    
    DataRecords db; 
    Inspection inspection ;
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
         inspection = new Inspection("Driver Seat Function",550,false);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of makeInspectionTaskArrayList method, of class DataRecords.
     */
    @Test
    public void testMakeInspectionTaskArrayList() {
        System.out.println("makeInspectionTaskArrayList");
        //Inspection[] args = null;
        
         ArrayList<Inspection> expResult = new  ArrayList<Inspection>();
         expResult.add(inspection);
         ArrayList<Inspection> result = db.makeInspectionTaskArrayList(inspection);
         result=db.fetchInspectionList("1005");
         assertEquals(expResult.get(0).getInspectionValue(), result.get(0).getInspectionValue());
        // TODO review the generated test code and remove the default call to fail.
          //fail("The test case is a prototype.");
    }

    /**
     * Test of makeRegNumInspectionList method, of class DataRecords.
     */
    @Test
    public void testMakeRegNumInspectionList() {
        System.out.println("makeRegNumInspectionList");
        //DataRecords instance = new DataRecords();
        db.makeRegNumInspectionList();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
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
    public void testSaveInspectionResult_0args() {
        System.out.println("saveInspectionResult");
        DataRecords instance = new DataRecords();
        instance.saveInspectionResult();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of saveInspectionResult method, of class DataRecords.
     */
    @Test
    public void testSaveInspectionResult_int_ArrayList() {
        System.out.println("saveInspectionResult");
        String regNo ="" ;
        ArrayList<Inspection> inspectionresult = null;
        DataRecords instance = new DataRecords();
        instance.saveInspectionResult(regNo, inspectionresult);
        //assertEquals(tempArrayList.get(0).getInspectionValue(), tempArrayListfromdb.get(0).getInspectionValue());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of displaySaveInspectionResult method, of class DataRecords.
     */
    @Test
    public void testDisplaySaveInspectionResult() {
        System.out.println("displaySaveInspectionResult");
        String regNo ="1005" ;
        DataRecords instance = new DataRecords();
        ArrayList<Inspection>tempArrayListfromdb = instance.fetchInspectionList(regNo);
        instance.displaySaveInspectionResult(regNo);
        
        assertNotNull(tempArrayListfromdb);
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
        double costPaid = 1000.0;
        DataRecords instance = new DataRecords();
        instance.savePayment(regNo, costPaid);
        
        assertEquals(1000,instance.getPaymentDetails(regNo), 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
     public void testGetPaymentDetails() {
        System.out.println("savePayment");
        String regNo ="1001" ;
        double costPaid = 1000.0;
        DataRecords instance = new DataRecords();
        instance.savePayment(regNo, costPaid);
        
        assertEquals(1000,instance.getPaymentDetails(regNo), 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of saveInspectionResult method, of class DataRecords.
     */
    @Test
    
    public void testSaveInspectionResult_String_ArrayList() {
        System.out.println("saveInspectionResult");
        String regNo = "";
        ArrayList<Inspection> inspectionresult = null;
        DataRecords instance = new DataRecords();
        instance.saveInspectionResult(regNo, inspectionresult);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
