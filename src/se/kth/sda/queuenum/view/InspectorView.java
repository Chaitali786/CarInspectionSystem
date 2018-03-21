/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import se.kth.sda.queuenum.controller.InspectionController;
import se.kth.sda.queuenum.model.CreditCard;
import se.kth.sda.queuenum.model.Inspection;

/**
 *
 * @author tmp-sda-1160
 */
public class InspectorView {

    private InspectionController contr;
    private ArrayList<Inspection> inspectionList;
    private ArrayList<Inspection> inspectionResult;

    public InspectorView(InspectionController contr) {
        this.contr = contr;
        inspectionList = new ArrayList<>();
        inspectionResult = new ArrayList<>();
    }

    public void openGarageDoor() {
        contr.openGarageDoor();
    }

    public void closeGarageDoor() {
        contr.closeGarageDoor();
    }

    public void performInspection() {
        System.out.println("Enter Registration No");
        Scanner sc = new Scanner(System.in);
        int regNo = sc.nextInt();
        boolean isRegNoVerified = contr.verifyRegistrationNo(regNo);
        if (isRegNoVerified) {
            inspectionList = contr.fetchInspectionList(regNo);
            displayInspectionList(regNo, inspectionList);
            double totalcost = contr.calculateCost(inspectionList);
            System.out.println("Total Cost: " + totalcost);
            makePaymentByCashOrCard(regNo, totalcost);
            System.out.println("Performing inspection......");
            System.out.println("Inspection Result......");
            System.out.println();

            System.out.println("*****************************************************************");
            System.out.println("##################  INSPECTION RESULT CHECKLIST   ###############");
            System.out.println("*****************************************************************");
            makeInspectionresult();
            contr.saveInspectionResult(regNo, inspectionResult);
            System.out.println("Inspection done for Vehicle" + regNo);
        } else {
            System.out.println("Enter Valid Regisitration No");
        }

    }

    void makeInspectionresult() {
        inspectionResult.add(new Inspection("Driver Seat Function", 200, false));
        inspectionResult.add(new Inspection("Mirror Functions", 300, true));
        inspectionResult.add(new Inspection("Navigation System", 500, true));
    }

    void displayInspectionList(int regNo, ArrayList<Inspection> inspectionData) {
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

    void makePaymentByCashOrCard(int regNo, double totalCost) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to pay by Credit Card? enter yes or No");
        String payByCard = sc.next();
        if (payByCard.toLowerCase().equals("yes")) {
            System.out.println("Enter credit card details");
            CreditCard cardDetail = new CreditCard(5, "n", "holder", new Date(2018, 03, 03), 323);

            contr.makePayment(regNo, cardDetail, totalCost);
        } else {
            System.out.println("Enter cash amount");
            double cashPaid = sc.nextDouble();
            double refund = contr.makePayment(regNo, cashPaid, totalCost);
            System.out.println("Cash paid:" + cashPaid);
            System.out.println("Refund:" + refund);
        }
    }

}
