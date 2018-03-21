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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of recordPurchase method, of class CashRegistry.
     */
    @Test
    public void testRecordPurchase() {
        System.out.println("recordPurchase");
        double amount = 0;
        CashRegistry instance = new CashRegistry();
        instance.recordPurchase(amount);
        
    }

    /**
     * Test of enterPayment method, of class CashRegistry.
     */
    @Test
    public void testEnterPayment() {
        System.out.println("enterPayment");
        double amount = 0;
        CashRegistry instance = new CashRegistry();
        instance.enterPayment(amount);
    }

    /**
     * Test of giveChange method, of class CashRegistry.
     */
    @Test
    public void testGiveChange() {
        System.out.println("giveChange");
        CashRegistry instance = new CashRegistry();
        double expResult = 0;
        double result = instance.giveChange();
        assertEquals(expResult, result,0);
        
    }
    
}
