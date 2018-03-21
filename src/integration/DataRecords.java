/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 *
 * @author tmp-sda-1160
 */
import java.util.*;
import java.util.Map.Entry;

public class DataRecords {

    HashMap<String, Double> paymentList;
    InspectionDTO inspectionTaskDTO = new InspectionDTO(null, 0, false);
    HashMap<String, ArrayList<InspectionDTO>> inspectionList;

    public DataRecords() {
        inspectionList = new HashMap<String, ArrayList<InspectionDTO>>();
        paymentList = new HashMap<String, Double>();
        makeRegNumInspectionList();
    }

    public ArrayList<InspectionDTO> makeInspectionTaskArrayList(InspectionDTO... args) {
        ArrayList<InspectionDTO> inspectionArrayList = new ArrayList<InspectionDTO>();
        for (InspectionDTO arg : args) {
            inspectionArrayList.add(arg);
        }
        return inspectionArrayList;
    }

    public void makeRegNumInspectionList() {
        //inspectionList = new HashMap<Integer,ArrayList<String>>();
        inspectionList.put("1001", makeInspectionTaskArrayList(new InspectionDTO("Driver Seat Function", 200, false), new InspectionDTO("Mirror Functions", 300, false), new InspectionDTO("Navigation System", 500, false)));
        inspectionList.put("1002", makeInspectionTaskArrayList(new InspectionDTO("WindShield", 80, false), new InspectionDTO("Streeing wheel", 350, false), new InspectionDTO("Stalk Controls", 750, false), new InspectionDTO("Central locking functions", 120, false)));
        inspectionList.put("1003", makeInspectionTaskArrayList(new InspectionDTO("Pedal Function", 780, false), new InspectionDTO("Mirror Functions", 400, false), new InspectionDTO("Gear Shift Function", 560, false)));
        inspectionList.put("1004", makeInspectionTaskArrayList(new InspectionDTO("Engine Performance", 450, false), new InspectionDTO("Mirror Functions", 400, false), new InspectionDTO("Navigation System", 150, false)));
        inspectionList.put("1005", makeInspectionTaskArrayList(new InspectionDTO("Driver Seat Function", 550, false), new InspectionDTO("Mirror Functions", 300, false), new InspectionDTO("Central locking functions", 250, false), new InspectionDTO("Navigation System", 450, false)));
        inspectionList.put("1006", makeInspectionTaskArrayList(new InspectionDTO("Child locking functions", 440, false), new InspectionDTO("Mirror Functions", 660, false), new InspectionDTO("Navigation System", 330, false)));
        inspectionList.put("1007", makeInspectionTaskArrayList(new InspectionDTO("Stalk Controls", 750, false), new InspectionDTO("Mirror Functions", 660, false), new InspectionDTO("Navigation System", 150, false)));
        inspectionList.put("1008", makeInspectionTaskArrayList(new InspectionDTO("Stalk Controls", 750, false), new InspectionDTO("Mirror Functions", 660, false), new InspectionDTO("Navigation System", 150, false), new InspectionDTO("Central locking functions", 250, false)));
        inspectionList.put("1009", makeInspectionTaskArrayList(new InspectionDTO("GearShit Function", 450, false), new InspectionDTO("Headlight assembly", 550, false), new InspectionDTO("Navigation System", 150, false)));
        inspectionList.put("1010", makeInspectionTaskArrayList(new InspectionDTO("On-Board Computer", 340, false), new InspectionDTO("Central locking functions", 330, false), new InspectionDTO("Navigation System", 330, false)));
    }

    public boolean verifyRegistrationNo(String regNo) {
        Set<Entry<String, ArrayList<InspectionDTO>>> set = inspectionList.entrySet();
        Iterator<Entry<String, ArrayList<InspectionDTO>>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            String tempKey = (String) mentry.getKey();
            if (tempKey.equals(regNo)) {
                return true;
            }

        }//End of while

        return false;
    }//End Of VerifyNumber

    public ArrayList<InspectionDTO> fetchInspectionList(String regNo) {
        ArrayList<InspectionDTO> tempArrayList = new ArrayList<InspectionDTO>();

        Set set = inspectionList.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            String tempKey = (String) mentry.getKey();
            if (tempKey.equals(regNo)) {
                tempArrayList = (ArrayList<InspectionDTO>) mentry.getValue();

                //System.out.println(inspectionTaskDTO.getInspectionTask());
                //System.out.println(inspectionTaskDTO.getInspectionPrice());
                break;
            }
        }//End Of While

        return tempArrayList;

    }//End Of Function

    public void saveInspectionResult() {
        //inspectionList = new HashMap<Integer,ArrayList<String>>();
        inspectionList.put("1001", makeInspectionTaskArrayList(new InspectionDTO("Driver Seat Function", 200, false), new InspectionDTO("Mirror Functions", 300, true), new InspectionDTO("Navigation System", 500, false)));
        inspectionList.put("1002", makeInspectionTaskArrayList(new InspectionDTO("WindShield", 80, true), new InspectionDTO("Streeing wheel", 350, false), new InspectionDTO("Stalk Controls", 750, true), new InspectionDTO("Central locking functions", 120, false)));
        inspectionList.put("1003", makeInspectionTaskArrayList(new InspectionDTO("Pedal Function", 780, true), new InspectionDTO("Mirror Functions", 400, true), new InspectionDTO("Gear Shift Function", 560, false)));
        inspectionList.put("1004", makeInspectionTaskArrayList(new InspectionDTO("Engine Performance", 450, false), new InspectionDTO("Mirror Functions", 400, false), new InspectionDTO("Navigation System", 150, true)));
        inspectionList.put("1005", makeInspectionTaskArrayList(new InspectionDTO("Driver Seat Function", 550, true), new InspectionDTO("Mirror Functions", 300, true), new InspectionDTO("Central locking functions", 250, false), new InspectionDTO("Navigation System", 450, false)));
        inspectionList.put("1006", makeInspectionTaskArrayList(new InspectionDTO("Child locking functions", 440, true), new InspectionDTO("Mirror Functions", 660, false), new InspectionDTO("Navigation System", 330, true)));
        inspectionList.put("1007", makeInspectionTaskArrayList(new InspectionDTO("Stalk Controls", 750, true), new InspectionDTO("Mirror Functions", 660, true), new InspectionDTO("Navigation System", 150, false)));
        inspectionList.put("1008", makeInspectionTaskArrayList(new InspectionDTO("Stalk Controls", 750, false), new InspectionDTO("Mirror Functions", 660, true), new InspectionDTO("Navigation System", 150, true), new InspectionDTO("Central locking functions", 250, true)));
        inspectionList.put("1009", makeInspectionTaskArrayList(new InspectionDTO("GearShit Function", 450, true), new InspectionDTO("Headlight assembly", 550, false), new InspectionDTO("Navigation System", 150, true)));
        inspectionList.put("1010", makeInspectionTaskArrayList(new InspectionDTO("On-Board Computer", 340, false), new InspectionDTO("Central locking functions", 330, true), new InspectionDTO("Navigation System", 330, false)));
        //displaySaveInspectionResult(regNo);
    }

    public void saveInspectionResult(String regNo, ArrayList<InspectionDTO> inspectionresult) {
        //inspectionList = new HashMap<Integer,ArrayList<String>>();
        inspectionList.put(regNo, inspectionresult);

    }

    public void displaySaveInspectionResult(String regNo) {
        System.out.println("*****************************************************************");
        System.out.println("##################  INSPECTION RESULT CHECKLIST   ###############");
        System.out.println("*****************************************************************");

        if (verifyRegistrationNo(regNo)) {
            ArrayList<InspectionDTO> tempArrayList = fetchInspectionList(regNo);
            System.out.printf(" Registration Number :    " + regNo);
            System.out.println();
            System.out.println();
            System.out.printf("%-22s%-40s%-22s\n", "Inspection List", "Price", "Status");

            System.out.println("----------------------------------------------------------------");

            for (int i = 0; i < tempArrayList.size(); i++) {
                System.out.printf("%-22s%-40s%-22s\n", tempArrayList.get(i).getInspectionValue(), tempArrayList.get(i).getCost(), tempArrayList.get(i).getInspectionStatus());

                System.out.println();

            }
        }
    }//end of function

    public void savePayment(String regNo, double costPaid) {
        paymentList.put(regNo, costPaid);
        System.out.println("Payment Saved Sucessfully!!!!!");
    }

}
