package view;

import controller.InspectionController;

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
    
    /**
     * Display next no in queue
     */
    public void displayNo()
    {
        System.out.println("Press button");
        //Scanner sc = new Scanner(System.in);
        
        contr.displayNo();
       
    }

}
