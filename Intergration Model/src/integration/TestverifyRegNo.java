package integration;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestverifyRegNo {
    @Test
	public void test() {
    	Database db = new Database();
    	//boolean result=false ;
    	db.makeRegNumInspectionList();
    	assertEquals(true,db.verifyRegNo(1010));
		//fail("Not yet implemented");
	}
}
