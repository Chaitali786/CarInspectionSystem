package controller;

import java.util.ArrayList;
import integration.Display;
import integration.Printer;
import model.Garage;
import model.Inspections;
import model.QueueNumber;
import integration.InspectionDTO;
import integration.CreditCard;
import model.CashRegistry;
import model.PaymentAuthorization;

/**
 * This is the application's only controller. All calls to the model pass
 * through here.
 */
public class InspectionController {

    private Display display;
    private Garage garage;
    int currentqueueNo = 0;
    private Inspections inspections;
    private PaymentAuthorization paymentAuthorization;
    private CashRegistry cashRegistry;
    private Printer printer;
    private QueueNumber queueNo;

    public InspectionController(QueueNumber queueNumber) {

        this.display = new Display();
        this.garage = new Garage();
        this.inspections = new Inspections();
        this.paymentAuthorization = new PaymentAuthorization();
        this.cashRegistry = new CashRegistry();
        this.printer = new Printer();
        this.queueNo = queueNumber;
    }

    /**
     * to Display next queue No
     */
    public void displayNo() {
        queueNo.incrementQueueNo();
        currentqueueNo = queueNo.getQueueNo();
        display.displayNo(currentqueueNo);
    }

    /**
     * to open Garage door
     */
    public void openGarageDoor() {
        garage.nextCustomer();
    }

    /**
     * to close Garage door
     */
    public void closeGarageDoor() {
        garage.closeDoor();
    }

    /**
     * to verify if Reg No exist
     */
    public boolean verifyRegistrationNo(String regNo) {
        return inspections.verifyRegistrationNo(regNo);
    }

    /**
     * to fetch inspection list for given reg no
     */
    public ArrayList<InspectionDTO> fetchInspectionList(String regNo) {

        return inspections.fetchInspectionList(regNo);
    }

    /**
     * to save inspection result
     */
    public void saveInspectionResult(String regNo, ArrayList<InspectionDTO> inspectionResult) {
        inspections.saveInspectionResult(regNo, inspectionResult);
    }

    /**
     * Make payment by Credit card
     * @param regNo
     * @param cardDetail
     * @param cost 
     */
    public void makePayment(String regNo, CreditCard cardDetail, double cost) {
        boolean isPaymentApproved = paymentAuthorization.authorizePayment(cardDetail, cost);
        if (isPaymentApproved) {
            savePayment(regNo, cost);
        }
    }

    /**
     * Make payment by cash
     * @param regNo
     * @param cashPaid
     * @param cost
     * @return 
     */
    public double makePayment(String regNo, double cashPaid, double cost) {
        cashRegistry.recordPurchase(cost);
        cashRegistry.enterPayment(cashPaid);
        double refund = cashRegistry.giveChange();
        savePayment(regNo, cost);
        return refund;
    }

    /**
     * To save payment in Database
     * @param regNo
     * @param cost 
     */
    public void savePayment(String regNo, double cost) {
        inspections.savePayment(regNo, cost);

    }
    /**
     * To calculate total cost for all the inspections
     * @param inspectionList
     * @return 
     */
    public double calculateCost(ArrayList<InspectionDTO> inspectionList) {
        double totalcost = inspections.calculateCost(inspectionList);
        printer.printCost(totalcost);
        return totalcost;
    }
}
