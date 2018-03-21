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

    /**
     * Test of makeInspectionTaskArrayList method, of class DataRecords.
     */
    @Ignore
    public void testMakeInspectionTaskArrayList() {
        System.out.println("makeInspectionTaskArrayList");
        InspectionDTO[] args = null;
        DataRecords instance = new DataRecords();
        ArrayList<InspectionDTO> expResult = null;
        ArrayList<InspectionDTO> result = instance.makeInspectionTaskArrayList(args);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeRegNumInspectionList method, of class DataRecords.
     */
    @Ignore
    public void testMakeRegNumInspectionList() {
        System.out.println("makeRegNumInspectionList");
        DataRecords instance = new DataRecords();
        instance.makeRegNumInspectionList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
       ArrayList<InspectionDTO> tempArrayList = new ArrayList<InspectionDTO>();
		 ArrayList<InspectionDTO> tempArrayListfromdb =  new ArrayList<InspectionDTO>();
    	tempArrayListfromdb=db.fetchInspectionList("1005");
    	tempArrayList.add(new InspectionDTO("Driver Seat Function",550,false));
    	tempArrayList.add(new InspectionDTO("Mirror Functions",300,false));
    	tempArrayList.add(new InspectionDTO("Central locking functions",250,false));
    	tempArrayList.add(new InspectionDTO("Navigation System",450,false));
       	assertNotNull(tempArrayListfromdb);
        assertEquals(tempArrayList.get(0).getInspectionValue(), tempArrayListfromdb.get(0).getInspectionValue());
    }

    /**
     * Test of saveInspectionResult method, of class DataRecords.
     */
    @Ignore
    public void testSaveInspectionResult_0args() {
        System.out.println("saveInspectionResult");
        DataRecords instance = new DataRecords();
        instance.saveInspectionResult();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveInspectionResult method, of class DataRecords.
     */
    @Ignore
    public void testSaveInspectionResult_int_ArrayList() {
        System.out.println("saveInspectionResult");
       String regNo ="" ;
        ArrayList<InspectionDTO> inspectionresult = null;
        DataRecords instance = new DataRecords();
        instance.saveInspectionResult(regNo, inspectionresult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySaveInspectionResult method, of class DataRecords.
     */
    @Ignore
    public void testDisplaySaveInspectionResult() {
        System.out.println("displaySaveInspectionResult");
        String regNo ="" ;
        DataRecords instance = new DataRecords();
        instance.displaySaveInspectionResult(regNo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of savePayment method, of class DataRecords.
     */
    @Ignore
    public void testSavePayment() {
        System.out.println("savePayment");
        String regNo ="" ;
        double costPaid = 0.0;
        DataRecords instance = new DataRecords();
        instance.savePayment(regNo, costPaid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
