/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.model;

/**
 *
 * @author tmp-sda-1160
 */
public class Vehicle {
  // attributes of vehicle 
  private String RegNo;
  private String OwnerName;

  //Creates Vehicle

    public Vehicle(String RegNo, String OwnerName) {
        this.RegNo = RegNo;
        this.OwnerName = OwnerName;
    }
    

    // getters and setters for vehicle
    public String getRegNo() {        
        return RegNo;
    }

    public void setRegNo(String RegNo) {
        this.RegNo = RegNo;
    }

    public String getOwnerName() {        
        return OwnerName;
   }

    public void setOwnerName(String OwnerName) {
       this.OwnerName = OwnerName;
    }
 
 
  
 
    
}
