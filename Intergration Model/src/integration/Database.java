package integration;
import java.util.*;
import java.util.Map.Entry;

public class Database {
	  
	  HashMap<Integer,Float> paymentList = new HashMap<Integer,Float>();
	  InspectionTaskDTO inspectionTaskDTO=new InspectionTaskDTO(null, 0,false);
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
         inspectionList.put(1001,makeInspectionTaskArrayList(new InspectionTaskDTO("Driver Seat Function",200,false),new InspectionTaskDTO("Mirror Functions",300,false),new InspectionTaskDTO("Navigation System",500,false)));
    	 inspectionList.put(1002,makeInspectionTaskArrayList(new InspectionTaskDTO("WindShield",80,false),new InspectionTaskDTO("Streeing wheel",350,false),new InspectionTaskDTO("Stalk Controls",750,false),new InspectionTaskDTO("Central locking functions",120,false)));
    	 inspectionList.put(1003,makeInspectionTaskArrayList(new InspectionTaskDTO("Pedal Function",780,false),new InspectionTaskDTO("Mirror Functions",400,false),new InspectionTaskDTO("Gear Shift Function",560,false)));
    	 inspectionList.put(1004,makeInspectionTaskArrayList(new InspectionTaskDTO("Engine Performance",450,false),new InspectionTaskDTO("Mirror Functions",400,false),new InspectionTaskDTO("Navigation System",150,false)));
    	 inspectionList.put(1005,makeInspectionTaskArrayList(new InspectionTaskDTO("Driver Seat Function",550,false),new InspectionTaskDTO("Mirror Functions",300,false),new InspectionTaskDTO("Central locking functions",250,false),new InspectionTaskDTO("Navigation System",450,false)));
    	 inspectionList.put(1006,makeInspectionTaskArrayList(new InspectionTaskDTO("Child locking functions",440,false),new InspectionTaskDTO("Mirror Functions",660,false),new InspectionTaskDTO("Navigation System",330,false)));
    	 inspectionList.put(1007,makeInspectionTaskArrayList(new InspectionTaskDTO("Stalk Controls",750,false),new InspectionTaskDTO("Mirror Functions",660,false),new InspectionTaskDTO("Navigation System",150,false)));
    	 inspectionList.put(1008,makeInspectionTaskArrayList(new InspectionTaskDTO("Stalk Controls",750,false),new InspectionTaskDTO("Mirror Functions",660,false),new InspectionTaskDTO("Navigation System",150,false),new InspectionTaskDTO("Central locking functions",250,false)));
    	 inspectionList.put(1009,makeInspectionTaskArrayList(new InspectionTaskDTO("GearShit Function",450,false),new InspectionTaskDTO("Headlight assembly",550,false),new InspectionTaskDTO("Navigation System",150,false)));
    	 inspectionList.put(1010,makeInspectionTaskArrayList(new InspectionTaskDTO("On-Board Computer",340,false),new InspectionTaskDTO("Central locking functions",330,false),new InspectionTaskDTO("Navigation System",330,false)));
      }
     public boolean verifyRegNo(int regNo)
     {
    	 Set<Entry<Integer, ArrayList<InspectionTaskDTO>>> set = inspectionList.entrySet();
    	 Iterator<Entry<Integer, ArrayList<InspectionTaskDTO>>> iterator = set.iterator();
    	 
    	 while(iterator.hasNext()) {
    		 Map.Entry mentry = (Map.Entry)iterator.next();
    		 int tempKey = (int) mentry.getKey();
    		 if( tempKey == regNo)
    		 { return true;}
    		    			 
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
     public void saveInspectionResult()
     {
   	 //inspectionList = new HashMap<Integer,ArrayList<String>>();
     inspectionList.put(1001,makeInspectionTaskArrayList(new InspectionTaskDTO("Driver Seat Function",200,false),new InspectionTaskDTO("Mirror Functions",300,true),new InspectionTaskDTO("Navigation System",500,false)));
   	 inspectionList.put(1002,makeInspectionTaskArrayList(new InspectionTaskDTO("WindShield",80,true),new InspectionTaskDTO("Streeing wheel",350,false),new InspectionTaskDTO("Stalk Controls",750,true),new InspectionTaskDTO("Central locking functions",120,false)));
   	 inspectionList.put(1003,makeInspectionTaskArrayList(new InspectionTaskDTO("Pedal Function",780,true),new InspectionTaskDTO("Mirror Functions",400,true),new InspectionTaskDTO("Gear Shift Function",560,false)));
   	 inspectionList.put(1004,makeInspectionTaskArrayList(new InspectionTaskDTO("Engine Performance",450,false),new InspectionTaskDTO("Mirror Functions",400,false),new InspectionTaskDTO("Navigation System",150,true)));
   	 inspectionList.put(1005,makeInspectionTaskArrayList(new InspectionTaskDTO("Driver Seat Function",550,true),new InspectionTaskDTO("Mirror Functions",300,true),new InspectionTaskDTO("Central locking functions",250,false),new InspectionTaskDTO("Navigation System",450,false)));
   	 inspectionList.put(1006,makeInspectionTaskArrayList(new InspectionTaskDTO("Child locking functions",440,true),new InspectionTaskDTO("Mirror Functions",660,false),new InspectionTaskDTO("Navigation System",330,true)));
   	 inspectionList.put(1007,makeInspectionTaskArrayList(new InspectionTaskDTO("Stalk Controls",750,true),new InspectionTaskDTO("Mirror Functions",660,true),new InspectionTaskDTO("Navigation System",150,false)));
   	 inspectionList.put(1008,makeInspectionTaskArrayList(new InspectionTaskDTO("Stalk Controls",750,false),new InspectionTaskDTO("Mirror Functions",660,true),new InspectionTaskDTO("Navigation System",150,true),new InspectionTaskDTO("Central locking functions",250,true)));
   	 inspectionList.put(1009,makeInspectionTaskArrayList(new InspectionTaskDTO("GearShit Function",450,true),new InspectionTaskDTO("Headlight assembly",550,false),new InspectionTaskDTO("Navigation System",150,true)));
   	 inspectionList.put(1010,makeInspectionTaskArrayList(new InspectionTaskDTO("On-Board Computer",340,false),new InspectionTaskDTO("Central locking functions",330,true),new InspectionTaskDTO("Navigation System",330,false)));
   	 //displaySaveInspectionResult(regNo);
     }
     public void displaySaveInspectionResult(int regNo)
     {
    	//System.out.println("Enter Registration Number:\n");
 		//int regNo=sc.nextInt();
 		if(verifyRegNo(regNo))
 		{
 			ArrayList<InspectionTaskDTO> tempArrayList = fetchInspectionList(regNo);
 			System.out.printf(" Registration Number :    "+regNo);
 			System.out.println();
 			System.out.println();
 			System.out.printf("%-22s%-40s%-22s\n","Inspection List","Price","Status");
 	       
 			System.out.println("----------------------------------------------------------------");
 			
 			
 			for(int i=0;i<tempArrayList.size();i++)
 			{			
 				System.out.printf("%-22s%-40s%-22s\n",tempArrayList.get(i).getInspectionTask(),tempArrayList.get(i).getInspectionPrice(),tempArrayList.get(i).getInspectionStatus());
 				
 				System.out.println();
 				
 			}
     }
     }//end of function
     public void savePayment(int regNo,float costPaid)
     {
    	 paymentList.put(regNo,costPaid);
    	 System.out.println("Payment Saved Sucessfully!!!!!");
     }
     
}//End of Class
