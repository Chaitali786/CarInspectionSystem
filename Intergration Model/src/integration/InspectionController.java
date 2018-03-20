package se.kth.sda.queuenum.controller;

import java.util.ArrayList;
import se.kth.sda.queuenum.integration.Display;
import se.kth.sda.queuenum.model.Garage;
import se.kth.sda.queuenum.model.Inspections;
import se.kth.sda.queuenum.model.QueueNumber;
import se.kth.sda.queuenum.integration.Inspection;
import se.kth.sda.queuenum.integration.CreditCard;
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
     
    public InspectionController() {
        queueNo = new QueueNumber();
         this.display = new Display();
         this.garage= new Garage();
         this.inspections= new Inspections();
         this.paymentAuthorization= new PaymentAuthorization();
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
     
      public void saveInspectionResult(ArrayList<Inspection> failedResult,ArrayList<Inspection> passedResult)
    {
         inspections.saveInspectionResult(failedResult,passedResult);
    }
      
       public void makePayment(int regNo,CreditCard cardDetail,double cost)
    {
        boolean isPaymentApproved =paymentAuthorization.authorizePayment(cardDetail, cost);
        if(isPaymentApproved)
            savePayment(regNo,cost);
    }
       
          public void makePayment(int regNo,double cashPaid,double cost)
    {
        //call to cash registry
        // it will return some refund amount
        savePayment(regNo,cost);
    }
       public void savePayment(int regNo,double cost)
    {
        inspections.savePayment(regNo, cost);
        
    }
        public double calculateCost(ArrayList<Inspection> inspectionList)
    {
        
        return inspections.calculateCost(inspectionList);
    }
}
