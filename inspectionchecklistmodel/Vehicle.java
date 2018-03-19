
package se.kth.iv1350.model;

/**
 * This class stores the information about Vehicles.
 * @author tmp-sda-1163
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
