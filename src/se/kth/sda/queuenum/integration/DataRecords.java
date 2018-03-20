/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.sda.queuenum.integration;

/**
 *
 * @author tmp-sda-1160
 */
import java.util.*;
import java.util.Map.Entry;
import se.kth.sda.queuenum.model.Inspection;

public class DataRecords {
	  
	  HashMap<Integer,Double> paymentList;
	  Inspection inspectionTaskDTO=new Inspection(null, 0,false);
	  HashMap<Integer,ArrayList<Inspection>> inspectionList ;
	  
      public DataRecords()
      {
          inspectionList = new HashMap<Integer,ArrayList<Inspection>>();
          paymentList = new HashMap<Integer,Double>();
          makeRegNumInspectionList();
      }
          public ArrayList<Inspection> makeInspectionTaskArrayList(Inspection ... args)
      {   
    	  ArrayList<Inspection> inspectionArrayList = new ArrayList<Inspection>();
    	  for(Inspection arg  : args)
    	  {
    		  inspectionArrayList.add(arg);
    	  }
    	  return inspectionArrayList;
      }
      
      
     public void makeRegNumInspectionList()
      {
    	 //inspectionList = new HashMap<Integer,ArrayList<String>>();
         inspectionList.put(1001,makeInspectionTaskArrayList(new Inspection("Driver Seat Function",200,false),new Inspection("Mirror Functions",300,false),new Inspection("Navigation System",500,false)));
    	 inspectionList.put(1002,makeInspectionTaskArrayList(new Inspection("WindShield",80,false),new Inspection("Streeing wheel",350,false),new Inspection("Stalk Controls",750,false),new Inspection("Central locking functions",120,false)));
    	 inspectionList.put(1003,makeInspectionTaskArrayList(new Inspection("Pedal Function",780,false),new Inspection("Mirror Functions",400,false),new Inspection("Gear Shift Function",560,false)));
    	 inspectionList.put(1004,makeInspectionTaskArrayList(new Inspection("Engine Performance",450,false),new Inspection("Mirror Functions",400,false),new Inspection("Navigation System",150,false)));
    	 inspectionList.put(1005,makeInspectionTaskArrayList(new Inspection("Driver Seat Function",550,false),new Inspection("Mirror Functions",300,false),new Inspection("Central locking functions",250,false),new Inspection("Navigation System",450,false)));
    	 inspectionList.put(1006,makeInspectionTaskArrayList(new Inspection("Child locking functions",440,false),new Inspection("Mirror Functions",660,false),new Inspection("Navigation System",330,false)));
    	 inspectionList.put(1007,makeInspectionTaskArrayList(new Inspection("Stalk Controls",750,false),new Inspection("Mirror Functions",660,false),new Inspection("Navigation System",150,false)));
    	 inspectionList.put(1008,makeInspectionTaskArrayList(new Inspection("Stalk Controls",750,false),new Inspection("Mirror Functions",660,false),new Inspection("Navigation System",150,false),new Inspection("Central locking functions",250,false)));
    	 inspectionList.put(1009,makeInspectionTaskArrayList(new Inspection("GearShit Function",450,false),new Inspection("Headlight assembly",550,false),new Inspection("Navigation System",150,false)));
    	 inspectionList.put(1010,makeInspectionTaskArrayList(new Inspection("On-Board Computer",340,false),new Inspection("Central locking functions",330,false),new Inspection("Navigation System",330,false)));
      }
     public boolean verifyRegistrationNo(int regNo)
     {
    	 Set<Entry<Integer, ArrayList<Inspection>>> set = inspectionList.entrySet();
    	 Iterator<Entry<Integer, ArrayList<Inspection>>> iterator = set.iterator();
    	 
    	 while(iterator.hasNext()) {
    		 Map.Entry mentry = (Map.Entry)iterator.next();
    		 int tempKey = (int) mentry.getKey();
    		 if( tempKey == regNo)
    		 { return true;}
    		    			 
    	 }//End of while
         
    	 return false;
     }//End Of VerifyNumber
     
   
	public ArrayList<Inspection> fetchInspectionList(int regNo)
     {
    	 ArrayList<Inspection> tempArrayList = new ArrayList<Inspection>();
    	 

    		 Set set = inspectionList.entrySet();
    		 Iterator iterator = set.iterator();
    		 while(iterator.hasNext()) {
    			 Map.Entry mentry = (Map.Entry)iterator.next(); 
    			 int tempKey = (int) mentry.getKey();
    			 if( tempKey == regNo)
    			 {   
    				 tempArrayList = (ArrayList<Inspection>)mentry.getValue();
    				 
    				 //System.out.println(inspectionTaskDTO.getInspectionTask());
    				 //System.out.println(inspectionTaskDTO.getInspectionPrice());
    				 break;
    			 }      
    		 }//End Of While
    	
    	 
        return tempArrayList;
    	 
     }//End Of Function
     public void saveInspectionResult()
     {
   	 //inspectionList = new HashMap<Integer,ArrayList<String>>();
     inspectionList.put(1001,makeInspectionTaskArrayList(new Inspection("Driver Seat Function",200,false),new Inspection("Mirror Functions",300,true),new Inspection("Navigation System",500,false)));
   	 inspectionList.put(1002,makeInspectionTaskArrayList(new Inspection("WindShield",80,true),new Inspection("Streeing wheel",350,false),new Inspection("Stalk Controls",750,true),new Inspection("Central locking functions",120,false)));
   	 inspectionList.put(1003,makeInspectionTaskArrayList(new Inspection("Pedal Function",780,true),new Inspection("Mirror Functions",400,true),new Inspection("Gear Shift Function",560,false)));
   	 inspectionList.put(1004,makeInspectionTaskArrayList(new Inspection("Engine Performance",450,false),new Inspection("Mirror Functions",400,false),new Inspection("Navigation System",150,true)));
   	 inspectionList.put(1005,makeInspectionTaskArrayList(new Inspection("Driver Seat Function",550,true),new Inspection("Mirror Functions",300,true),new Inspection("Central locking functions",250,false),new Inspection("Navigation System",450,false)));
   	 inspectionList.put(1006,makeInspectionTaskArrayList(new Inspection("Child locking functions",440,true),new Inspection("Mirror Functions",660,false),new Inspection("Navigation System",330,true)));
   	 inspectionList.put(1007,makeInspectionTaskArrayList(new Inspection("Stalk Controls",750,true),new Inspection("Mirror Functions",660,true),new Inspection("Navigation System",150,false)));
   	 inspectionList.put(1008,makeInspectionTaskArrayList(new Inspection("Stalk Controls",750,false),new Inspection("Mirror Functions",660,true),new Inspection("Navigation System",150,true),new Inspection("Central locking functions",250,true)));
   	 inspectionList.put(1009,makeInspectionTaskArrayList(new Inspection("GearShit Function",450,true),new Inspection("Headlight assembly",550,false),new Inspection("Navigation System",150,true)));
   	 inspectionList.put(1010,makeInspectionTaskArrayList(new Inspection("On-Board Computer",340,false),new Inspection("Central locking functions",330,true),new Inspection("Navigation System",330,false)));
   	 //displaySaveInspectionResult(regNo);
     }
      public void saveInspectionResult(int  regNo, ArrayList<Inspection> inspectionresult)
     {
   	 //inspectionList = new HashMap<Integer,ArrayList<String>>();
         inspectionList.put(regNo, inspectionresult);
    
     }
     public void displaySaveInspectionResult(int regNo)
     {
    	//System.out.println("Enter Registration Number:\n");
 		//int regNo=sc.nextInt();
 		if(verifyRegistrationNo(regNo))
 		{
 			ArrayList<Inspection> tempArrayList = fetchInspectionList(regNo);
 			System.out.printf(" Registration Number :    "+regNo);
 			System.out.println();
 			System.out.println();
 			System.out.printf("%-22s%-40s%-22s\n","Inspection List","Price","Status");
 	       
 			System.out.println("----------------------------------------------------------------");
 			
 			
 			for(int i=0;i<tempArrayList.size();i++)
 			{			
 				System.out.printf("%-22s%-40s%-22s\n",tempArrayList.get(i).getInspectionValue(),tempArrayList.get(i).getCost(),tempArrayList.get(i).getInspectionStatus());
 				
 				System.out.println();
 				
 			}
     }
     }//end of function
     public void savePayment(int regNo,double costPaid)
     {
    	 paymentList.put(regNo,costPaid);
    	 System.out.println("Payment Saved Sucessfully!!!!!");
     }
     
}
