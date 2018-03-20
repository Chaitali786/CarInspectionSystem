/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.model;

import se.kth.sda.queuenum.integration.Inspection;
import java.util.ArrayList;
import se.kth.sda.queuenum.integration.DataRecords;

/**
 *
 * @author tmp-sda-1160
 */
public class Inspections {
    
    private DataRecords db;
   
    
    public Inspections()
    {
        this.db= new DataRecords();
       
    }
    
     
    public boolean verifyRegistrationNo(String regNo)
    {
        boolean isRegNoVerified = db.verifyRegistrationNo(regNo);
        return isRegNoVerified;
    }
    
    public ArrayList<Inspection> fetchInspectionList(String regNo)
    {
        ArrayList<Inspection> inspectionList= db.fetchInspectionList(regNo);
        calculateCost(inspectionList);
        return inspectionList;
    }
     public void saveInspectionResult(String regNo,ArrayList<Inspection> inspectionResult)
    {
         db.saveInspectionResult(regNo,inspectionResult);
         db.displaySaveInspectionResult(regNo);
    }
    
      public void savePayment(String regNo,double cost)
    {
        db.savePayment(regNo,cost);
        
    }
      
      public double calculateCost(ArrayList<Inspection> inspectionList)
    {
        double  totalCost = 0;
       for (Inspection inspection : inspectionList) {
           totalCost = totalCost + inspection.getCost();
      }
       return totalCost;
    }
      
      
     
}
