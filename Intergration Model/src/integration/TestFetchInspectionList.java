package integration;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestFetchInspectionList {

	@Test
	public void test() {
		Database db = new Database();
		 ArrayList<InspectionTaskDTO> tempArrayList = new ArrayList<InspectionTaskDTO>();
		 ArrayList<InspectionTaskDTO> tempArrayListfromdb =  new ArrayList<InspectionTaskDTO>();
    	//boolean result=false ;
    	db.makeRegNumInspectionList();
    	tempArrayListfromdb=db.fetchInspectionList(1005);
    	tempArrayList.add(new InspectionTaskDTO("Driver Seat Function",550,false));
    	tempArrayList.add(new InspectionTaskDTO("Mirror Functions",300,false));
    	tempArrayList.add(new InspectionTaskDTO("Central locking functions",250,false));
    	tempArrayList.add(new InspectionTaskDTO("Navigation System",450,false));
       	assertNotNull(tempArrayListfromdb);
    	assertEquals(tempArrayList.get(0).getInspectionTask(), tempArrayListfromdb.get(0).getInspectionTask());
		//fail("Not yet implemented");
	}

	
}
