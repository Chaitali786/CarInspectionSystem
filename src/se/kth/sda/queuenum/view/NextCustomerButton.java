package se.kth.sda.queuenum.view;

import java.util.Scanner;
import se.kth.sda.queuenum.controller.InspectionController;
import se.kth.sda.queuenum.model.QueueNumber;

/**
 * Pressing this button increments the displayed queue number.
 */
public class NextCustomerButton {
    private InspectionController contr;
    
    /**
     * Instantiates an object using the specified controller for system operations.
     * 
     * @param contr The controller used for all system operations.
     */
    public NextCustomerButton(InspectionController contr) {
        this.contr = contr;
    }

    
    public void displayNo()
    {
        System.out.println("Press button");
        //Scanner sc = new Scanner(System.in);
        
        contr.displayNo();
       
    }

}
