package se.kth.sda.queuenum.startup;

import se.kth.sda.queuenum.controller.InspectionController;
import se.kth.sda.queuenum.model.QueueNumber;
import se.kth.sda.queuenum.view.InspectorView;
import se.kth.sda.queuenum.view.NextCustomerButton;

/**
 * Starts the application.
 */
public class Main {
    /**
     * This is the main method of the entire application.
     * It initialize controller and QueueNumber
     * @param args There are no command line arguments.
     */
    public static void main(String[] args)  {
        QueueNumber queueNo = new QueueNumber();
        InspectionController contr = new InspectionController(queueNo);
        InspectorView view= new InspectorView(contr);
        
        NextCustomerButton nxb = new NextCustomerButton(contr);
        
        nxb.displayNo();
        view.openGarageDoor();
        view.performInspection();
        view.closeGarageDoor();
        nxb.displayNo();
              
    }

}
