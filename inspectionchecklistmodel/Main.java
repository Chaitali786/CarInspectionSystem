package se.kth.iv1350.model;

/**
 *
 * @author tmp-sda-1163
 */
public class Main {

    static Vehicle myVehicle = new Vehicle("DK521", "Oscar Tjong");
    static InspectionList Il = new InspectionList(myVehicle);

    public static void main(String[] args) {

        Il.addInspection("Break Operation", 200);
        Il.addInspection("Tyre condition", 100);
        Il.addInspection("Lights", 100);
        Il.addInspection("Windscreen Washers and wipers", 200);
        Il.addInspection("Speedometer", 200);
        Il.addInspection("Safety Belts", 100);
        Il.addInspection("Steering and Suspension", 200);
        Il.addInspection("Fuel system", 200);
        Il.addInspection("Airbags", 100);
        
       Il.calculateCost();

    }

}
