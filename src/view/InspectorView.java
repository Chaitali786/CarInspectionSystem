package view;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import controller.InspectionController;
import integration.CreditCard;
import integration.InspectionDTO;

/**
 * View for Inspector to view and enter inspection related data
 *
 * @author tmp-sda-1160
 */
public class InspectorView {

    private InspectionController contr;
    private ArrayList<InspectionDTO> inspectionList;
    private ArrayList<InspectionDTO> inspectionResult;

    /**
     * Constructor
     *
     * @param contr
     */
    public InspectorView(InspectionController contr) {
        this.contr = contr;
        inspectionList = new ArrayList<>();
        inspectionResult = new ArrayList<>();
    }

    /**
     * Opens garage Door
     */
    public void openGarageDoor() {
        contr.openGarageDoor();
    }

    /**
     * Closes garage Door
     */
    public void closeGarageDoor() {
        contr.closeGarageDoor();
    }

    /**
     * Verify Reg No and Fetch if Inspections exist for that Reg No. Customer
     * makes Payment Inspector saves the result
     */
    public boolean performInspection() {
        System.out.println("Enter Registration No");
        Scanner sc = new Scanner(System.in);

        try {
            String regNo = sc.next();

            boolean isRegNoVerified = contr.verifyRegistrationNo(regNo);
            if (isRegNoVerified) {
                inspectionList = contr.fetchInspectionList(regNo);
                displayInspectionList(regNo, inspectionList);
                double totalcost = contr.calculateCost(inspectionList);
                System.out.println("Total Cost: " + totalcost);
                boolean isPaymentDone = makePaymentByCashOrCard(regNo, totalcost);
                while (!isPaymentDone) {
                    System.out.println("Add Payment more than Total cost");
                    isPaymentDone = makePaymentByCashOrCard(regNo, totalcost);
                }

                System.out.println("Performing inspection......");
                System.out.println("Inspection Result......");
                System.out.println();

                makeInspectionresult(inspectionList);
                contr.saveInspectionResult(regNo, inspectionResult);
                System.out.println("Inspection done for Vehicle" + regNo);
                return true;

            } else {
                System.out.println("Enter Valid Regisitration No");
                return false;
            }

        } catch (InputMismatchException ex) {
            System.out.println("Enter Reg No in proper format");
        }

        return false;
    }

    /**
     * Make Inspection Result for every inspection done outside.
     *
     * @param inspections
     */
    void makeInspectionresult(ArrayList<InspectionDTO> inspections) {
        Scanner sc = new Scanner(System.in);
        boolean isInspectionDone;
        System.out.println("##################  Enter INSPECTION RESULT   ###############");
        for (InspectionDTO inspection : inspections) {
            System.out.println(inspection.getInspectionValue());
            System.out.println("Enter Inspection Result......Pass/ Fail");
            String result = sc.next();

            if (result.toLowerCase().equals("pass")) {
                isInspectionDone = true;
            } else {
                isInspectionDone = false;
            }
            inspectionResult.add(new InspectionDTO(inspection, isInspectionDone));
        }
    }

    /**
     * Display Inspection List for given Reg No
     *
     * @param regNo
     * @param inspectionData
     */
    void displayInspectionList(String regNo, ArrayList<InspectionDTO> inspectionData) {
        System.out.printf(" Registration Number :    " + regNo);
        System.out.println();
        System.out.println();
        System.out.printf("%-22s%-40s%-22s\n", "Inspection List", "Price", "Status");

        System.out.println("--------------------------------------------------------------------");

        for (int i = 0; i < inspectionData.size(); i++) {
            System.out.printf("%-22s%-40s%-22s\n", inspectionData.get(i).getInspectionValue(), inspectionData.get(i).getCost(), inspectionData.get(i).getInspectionStatus());

            System.out.println();

        }
    }

    /**
     * Ask user to choose payment by cash or card And make payment
     *
     * @param regNo
     * @param totalCost
     */
    boolean makePaymentByCashOrCard(String regNo, double totalCost) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to pay by Credit Card? enter yes or No");
        String payByCard = sc.next();
        if (payByCard.toLowerCase().equals("yes")) {
            System.out.println("Enter credit card details");
            System.out.println("Enter credit card pin");
            int pin = sc.nextInt();
            System.out.println("Enter credit card Owner name");
            String owner = sc.next();
            System.out.println("Enter credit card 3 digit CVV no");
            int cvv = sc.nextInt();
            CreditCard cardDetail = new CreditCard(pin, "n", owner, new Date(2018, 03, 03), cvv);
            contr.makePayment(regNo, cardDetail, totalCost);
            return true;
        } else {
            System.out.println("Enter cash amount");
            double cashPaid = sc.nextDouble();
            double refund = contr.makePayment(regNo, cashPaid, totalCost);
            if (refund >= 0) {
                System.out.println("Cash paid:" + cashPaid);
                System.out.println("Refund:" + refund);
                return true;
            }
            return false;
        }
    }

}
