
package se.kth.iv1350.model;

/**
 * This class contains the name and cost of the inspections, vehicle should have.
 * 
 * @author tmp-sda-1163
 */
public class Inspection {
    private String title;
    private double cost;

    //Constructor to create the objects from this class.
    public Inspection(String title, double cost) {
        this.title = title;
        this.cost = cost;
    }

    // Getters & Setter for the attributes
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    
    
    
    
}
