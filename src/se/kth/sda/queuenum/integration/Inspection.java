/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.integration;

/**
 *
 * @author tmp-sda-1160
 */
public class Inspection {
    String inspectionValue;
    double cost;
    boolean status=false;
    public Inspection(String inspectionValue,double cost,boolean status)
    {
        this.inspectionValue= inspectionValue;
        this.cost=cost;
        this.status= status;
    
    }
    
     public String getInspectionValue() {
        return inspectionValue;
    }

    public void setInspectionValue(String title) {
        this.inspectionValue = title;
   }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
       this.cost = cost;
   }
    
    public boolean getInspectionStatus()
	{ return status;
        }
	

    public void setStatus(boolean status)
	{
		this.status=status;
        }
   
    
    
    
}
