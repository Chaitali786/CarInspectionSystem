package integration;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	InspectionTaskDTO inspectionTaskDTO=new InspectionTaskDTO(null, 0);
	ArrayList<InspectionTaskDTO> tempArrayList = new ArrayList<InspectionTaskDTO>();
	public static void main(String args[])
	{
		Database db =new Database();
		db.makeRegNumInspectionList();
		//ArrayList<InspectionTaskDTO> tempArrayList = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Registration Number:\n");
		int regNo=sc.nextInt();
		if(db.verifyRegNo(regNo))
		{
			ArrayList<InspectionTaskDTO> tempArrayList = db.fetchInspectionList(regNo);
			System.out.printf(" Registration Number :    "+regNo);
			System.out.println();
			System.out.println();
			System.out.printf("%-22s%-40s\n","Inspection List","Price");
	       
			System.out.println("------------------------------------");
			
			
			for(int i=0;i<tempArrayList.size();i++)
			{			
				System.out.printf("%-22s%-40s\n",tempArrayList.get(i).getInspectionTask(),tempArrayList.get(i).getInspectionPrice());
				
				System.out.println();
				
			}
			System.out.println();
			db.savePayment(regNo,200);
		}
		else
		{
			System.out.println("Invalid Registration Number:");
	    }
		
		
	}
}//End of class
