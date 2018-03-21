/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.integration;

/**
 * Inspection DTO
 *
 * @author tmp-sda-1160
 */
public class InspectionDTO {

    String inspectionValue;
    double cost;
    boolean status = false;

    /**
     * Status is False by default Inspector sets it true if Inspection is done
     *
     * @param inspectionValue
     * @param cost
     * @param status
     */
    public InspectionDTO(String inspectionValue, double cost, boolean status) {
        this.inspectionValue = inspectionValue;
        this.cost = cost;
        this.status = status;

    }

    /**
     * After performing inspection, inspector sends same inspection back with
     * staus
     *
     * @param inspection
     * @param status
     */
    public InspectionDTO(InspectionDTO inspection, boolean status) {
        this.inspectionValue = inspection.getInspectionValue();
        this.cost = inspection.getCost();
        this.status = status;

    }

    /**
     * To get Inspection value
     *
     * @return
     */
    public String getInspectionValue() {
        return inspectionValue;
    }

    /**
     * To set inspection Value
     *
     * @param title
     */
    public void setInspectionValue(String title) {
        this.inspectionValue = title;
    }

    /**
     * To get cost of each inspection
     *
     * @return
     */
    public double getCost() {
        return cost;
    }

    /**
     * To set cost of each inspection
     *
     * @return
     */
    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * To get status of each inspection
     *
     * @return
     */
    public boolean getInspectionStatus() {
        return status;
    }

    /**
     * To set cost of each inspection
     *
     * @return
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}
