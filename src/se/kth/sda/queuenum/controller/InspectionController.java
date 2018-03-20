package se.kth.sda.queuenum.controller;

import java.util.ArrayList;
import se.kth.sda.queuenum.integration.Display;
import se.kth.sda.queuenum.integration.Printer;
import se.kth.sda.queuenum.model.Garage;
import se.kth.sda.queuenum.model.Inspections;
import se.kth.sda.queuenum.model.QueueNumber;
import se.kth.sda.queuenum.model.Inspection;
import se.kth.sda.queuenum.model.CreditCard;
import se.kth.sda.queuenum.model.CashRegistry;
import se.kth.sda.queuenum.model.PaymentAuthorization;

/**
 * This is the application's only controller. All calls to the model pass through here.
 */
public class InspectionController {
    private QueueNumber queueNo;
    private Display display;
    private Garage garage;
    int currentqueueNo=0;
    private Inspections inspections;
    private PaymentAuthorization paymentAuthorization;
    private CashRegistry cashRegistry;
    private Printer printer;
     
    public InspectionController() {
        queueNo = new QueueNumber();
         this.display = new Display();
         this.garage= new Garage();
         this.inspections= new Inspections();
         this.paymentAuthorization= new PaymentAuthorization();
         this.cashRegistry= new CashRegistry();
         this.printer= new Printer();
    }

    public void displayNo() {
        queueNo.incrementQueueNo();
        currentqueueNo=queueNo.getQueueNo();
        display.displayNo(currentqueueNo);
    }
    
    public void openGarageDoor()
    {
        garage.nextCustomer();
    }
    
    
     public void closeGarageDoor()
    {
        garage.closeDoor();
    }
     
     
    public boolean verifyRegistrationNo(int regNo)
    {
        return inspections.verifyRegistrationNo(regNo);
    }
    
     public ArrayList<Inspection> fetchInspectionList(int regNo)
    {
        
        return inspections.fetchInspectionList(regNo);
    }
     
      public void saveInspectionResult(int regNo,ArrayList<Inspection> inspectionResult)
    {
         inspections.saveInspectionResult(regNo,inspectionResult);
    }
      
       public void makePayment(int regNo,CreditCard cardDetail,double cost)
    {
        boolean isPaymentApproved =paymentAuthorization.authorizePayment(cardDetail, cost);
        if(isPaymentApproved)
            savePayment(regNo,cost);
    }
       
          public double makePayment(int regNo,double cashPaid,double cost)
    {
        cashRegistry.recordPurchase(cost);
        cashRegistry.enterPayment(cashPaid);
        double refund= cashRegistry.giveChange();
        savePayment(regNo,cost);
        return refund;
    }
       public void savePayment(int regNo,double cost)
    {
        inspections.savePayment(regNo, cost);
        
    }
        public double calculateCost(ArrayList<Inspection> inspectionList)
    {
        double totalcost = inspections.calculateCost(inspectionList);
        printer.printCost(totalcost);
        return totalcost;
    }
}
