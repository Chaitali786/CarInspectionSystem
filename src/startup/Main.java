package startup;

import controller.InspectionController;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
         try {
            TimeUnit.SECONDS.sleep(15);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        view.closeGarageDoor();
        boolean isInspectionDone = view.performInspection();
        while (!isInspectionDone) {

            view.performInspection();

        }
        nxb.displayNo();
        view.openGarageDoor();

    }

}
