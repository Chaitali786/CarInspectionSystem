package startup;

import controller.InspectionController;
import model.QueueNumber;
import view.InspectorView;
import view.NextCustomerButton;

/**
 * Starts the application.
 */
public class Main {

    /**
     * This is the main method of the entire application. It initialize
     * controller and QueueNumber
     *
     * @param args There are no command line arguments.
     */
    public static void main(String[] args) {
        QueueNumber queueNo = new QueueNumber();
        InspectionController contr = new InspectionController(queueNo);
        InspectorView view = new InspectorView(contr);

        NextCustomerButton nxb = new NextCustomerButton(contr);

        nxb.displayNo();
        view.openGarageDoor();
        boolean isInspectionDone = view.performInspection();
        if (isInspectionDone) {
            view.closeGarageDoor();
            nxb.displayNo();
            view.openGarageDoor();
        } else {
            view.performInspection();

        }

    }

}
