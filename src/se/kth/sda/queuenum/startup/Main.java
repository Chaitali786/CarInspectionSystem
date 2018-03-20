package se.kth.sda.queuenum.startup;

import se.kth.sda.queuenum.controller.InspectionController;
import se.kth.sda.queuenum.view.InspectorView;
import se.kth.sda.queuenum.view.NextCustomerButton;

/**
 * Starts the application.
 */
public class Main {
    /**
     * This is the main method of the entire application.
     * 
     * @param args There are no command line arguments.
     */
    public static void main(String[] args)  {
        InspectionController contr = new InspectionController();
        NextCustomerButton nxb = new NextCustomerButton(contr);
        InspectorView view= new InspectorView(contr);
      nxb.displayNo();
      view.openGarageDoor();
      view.performInspection();
      view.closeGarageDoor();
              
    }

}
