package model;

import integration.InspectionDTO;
import java.util.ArrayList;
import integration.DataRecords;

/**
 * Inspections model to handle all inspection related data
 *
 * @author tmp-sda-1160
 */
public class Inspections {

    private DataRecords db;

    public Inspections() {
        this.db = new DataRecords();

    }

    /**
     * to verify if Reg No exist
     *
     * @param regNo
     * @return
     */
    public boolean verifyRegistrationNo(String regNo) {
        boolean isRegNoVerified = db.verifyRegistrationNo(regNo);
        return isRegNoVerified;
    }

    /**
     * to fetch inspection list for given reg no
     *
     * @param regNo
     * @return
     */
    public ArrayList<InspectionDTO> fetchInspectionList(String regNo) {
        ArrayList<InspectionDTO> inspectionList = db.fetchInspectionList(regNo);
        calculateCost(inspectionList);
        return inspectionList;
    }

    /**
     * to save inspection result
     *
     * @param regNo
     * @param inspectionResult
     */
    public void saveInspectionResult(String regNo, ArrayList<InspectionDTO> inspectionResult) {
        db.saveInspectionResult(regNo, inspectionResult);
        db.displaySaveInspectionResult(regNo);
    }

    /**
     * To save payment in Database
     *
     * @param regNo
     * @param cost
     */
    public void savePayment(String regNo, double cost) {
        db.savePayment(regNo, cost);

    }

    /**
     * To calculate total cost
     *
     * @param inspectionList
     * @return
     */
    public double calculateCost(ArrayList<InspectionDTO> inspectionList) {
        double totalCost = 0;
        for (InspectionDTO inspection : inspectionList) {
            totalCost = totalCost + inspection.getCost();
        }
        return totalCost;
    }

}
