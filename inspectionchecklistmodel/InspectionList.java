package se.kth.iv1350.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class would maintain and calcute the cost of inspection list.
 *
 * @author tmp-sda-1163
 */
public class InspectionList {

    private static ArrayList<Inspection> inspections;
    private Vehicle RegNo;

    // Creates inspection list
    public InspectionList(Vehicle RegNo) {
        inspections = new ArrayList<>();
         this.RegNo = RegNo;
    }

    // Add the inspections
    public void addInspection(String inspection, int cost) {

        inspections.add(new Inspection(inspection, cost));

    }

// Calculate the cost of inspection list
    public double calculateCost() {
        double sumCost = 0.0;
        for (Inspection inspection : inspections) {
            sumCost = sumCost + inspection.getCost();
        }
        return sumCost;
    }

    // Fetch the Inspection List for specific vehile
    public Inspection fetchInspectionList(String RegNo) {
        for (Inspection inspection : inspections) {
            if (RegNo.equals(this.RegNo)) {
                return inspection;
            }
        }
        return null;
    }

    //Verifies Registration number of Car
    public boolean verifyRegNo(String RegNo) {
        for (Inspection inspection : inspections) {
            if (RegNo.equals(this.RegNo)) {
                return true;
            }
        }
        return false;
    }

}
