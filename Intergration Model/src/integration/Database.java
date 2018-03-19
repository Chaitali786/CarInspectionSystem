package integration;
import java.util.*;

public class Database {
	  
	  HashMap<Integer,Float> paymentList = new HashMap<Integer,Float>();
	  InspectionTaskDTO inspectionTaskDTO=new InspectionTaskDTO(null, 0);
	  HashMap<Integer,ArrayList<InspectionTaskDTO>> inspectionList = new HashMap<Integer,ArrayList<InspectionTaskDTO>>();
	  
      public ArrayList<InspectionTaskDTO> makeInspectionTaskArrayList(InspectionTaskDTO ... args)
      {   
    	  ArrayList<InspectionTaskDTO> inspectionArrayList = new ArrayList<InspectionTaskDTO>();
    	  for(InspectionTaskDTO arg  : args)
    	  {
    		  inspectionArrayList.add(arg);
    	  }
    	  return inspectionArrayList;
      }
      
      
     public void makeRegNumInspectionList()
      {
    	 //inspectionList = new HashMap<Integer,ArrayList<String>>();
         inspectionList.put(1001,makeInspectionTaskArrayList(new InspectionTaskDTO("Driver Seat Function",200),new InspectionTaskDTO("Mirror Functions",300),new InspectionTaskDTO("Navigation System",500)));
    	 inspectionList.put(1002,makeInspectionTaskArrayList(new InspectionTaskDTO("WindShield",80),new InspectionTaskDTO("Streeing wheel",350),new InspectionTaskDTO("Stalk Controls",750),new InspectionTaskDTO("Central locking functions",120)));
    	 inspectionList.put(1003,makeInspectionTaskArrayList(new InspectionTaskDTO("Pedal Function",780),new InspectionTaskDTO("Mirror Functions",400),new InspectionTaskDTO("Gear Shift Function",560)));
    	 inspectionList.put(1004,makeInspectionTaskArrayList(new InspectionTaskDTO("Engine Performance",450),new InspectionTaskDTO("Mirror Functions",400),new InspectionTaskDTO("Navigation System",150)));
    	 inspectionList.put(1005,makeInspectionTaskArrayList(new InspectionTaskDTO("Driver Seat Function",550),new InspectionTaskDTO("Mirror Functions",300),new InspectionTaskDTO("Central locking functions",250),new InspectionTaskDTO("Navigation System",450)));
    	 inspectionList.put(1006,makeInspectionTaskArrayList(new InspectionTaskDTO("Child locking functions",440),new InspectionTaskDTO("Mirror Functions",660),new InspectionTaskDTO("Navigation System",330)));
    	 inspectionList.put(1007,makeInspectionTaskArrayList(new InspectionTaskDTO("Stalk Controls",750),new InspectionTaskDTO("Mirror Functions",660),new InspectionTaskDTO("Navigation System",150)));
    	 inspectionList.put(1008,makeInspectionTaskArrayList(new InspectionTaskDTO("Stalk Controls",750),new InspectionTaskDTO("Mirror Functions",660),new InspectionTaskDTO("Navigation System",150),new InspectionTaskDTO("Central locking functions",250)));
    	 inspectionList.put(1009,makeInspectionTaskArrayList(new InspectionTaskDTO("GearShit Function",450),new InspectionTaskDTO("Headlight assembly",550),new InspectionTaskDTO("Navigation System",150)));
    	 inspectionList.put(1010,makeInspectionTaskArrayList(new InspectionTaskDTO("On-Board Computer",340),new InspectionTaskDTO("Central locking functions",330),new InspectionTaskDTO("Navigation System",330)));
      }
     public boolean verifyRegNo(int regNo)
     {
    	 Set set = inspectionList.entrySet();
    	 Iterator iterator = set.iterator();
    	 while(iterator.hasNext()) {
    		 Map.Entry mentry = (Map.Entry)iterator.next();
    		 int tempKey = (int) mentry.getKey();
    		 if( tempKey == regNo)
    		 {
    			 return true;
    		 }
    	 }//End of while

    	 return false;
     }//End Of VerifyNumber
     
     @SuppressWarnings("unchecked")
	public ArrayList<InspectionTaskDTO> fetchInspectionList(int regNo)
     {
    	 ArrayList<InspectionTaskDTO> tempArrayList = new ArrayList<InspectionTaskDTO>();
    	 if( verifyRegNo(regNo))
    	 {

    		 Set set = inspectionList.entrySet();
    		 Iterator iterator = set.iterator();
    		 while(iterator.hasNext()) {
    			 Map.Entry mentry = (Map.Entry)iterator.next(); 
    			 int tempKey = (int) mentry.getKey();
    			 if( tempKey == regNo)
    			 {   
    				 tempArrayList = (ArrayList<InspectionTaskDTO>)mentry.getValue();
    				 
    				 //System.out.println(inspectionTaskDTO.getInspectionTask());
    				 //System.out.println(inspectionTaskDTO.getInspectionPrice());
    				 break;
    			 }      
    		 }//End Of While
    	 }
    	 
        return tempArrayList;
    	 
     }//End Of Function
     public void savePayment(int regNo,float costPaid)
     {
    	 paymentList.put(regNo,costPaid);
    	 System.out.println("Payment Saved Sucessfully!!!!!");
     }
     
}//End of Class
