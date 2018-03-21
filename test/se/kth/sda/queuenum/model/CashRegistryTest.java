/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yannick
 */
public class CashRegistryTest {
    
    private CashRegistry instance;
    public CashRegistryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         instance = new CashRegistry();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recordPurchase method, of class CashRegistry.
     */
   
    public void testRecordPurchase() {
        System.out.println("recordPurchase");
        double amount = 500;
        
        instance.recordPurchase(amount);
        
    }

    /**
     * Test of enterPayment method, of class CashRegistry.
     */
    
    public void testEnterPayment() {
        System.out.println("enterPayment");
        double amount = 1000;
        instance.enterPayment(amount);
    }

    /**
     * Test of giveChange method, of class CashRegistry.
     */
    @Test
    public void testGiveChange() {
        System.out.println("giveChange");
        testRecordPurchase();
        testEnterPayment();
        double expResult = 1000.0-500.0;
        double actual = instance.giveChange();
         assertEquals(expResult, actual,0);
        
    }
    
}
