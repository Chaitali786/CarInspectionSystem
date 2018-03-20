package integration;

public class InspectionTaskDTO {
	String inspectionTask;
	float price;
	boolean status=false;
	public InspectionTaskDTO(String inspectionTask, float price ,boolean status)
	{
		this.inspectionTask = inspectionTask;
		this.price = price;
		this.status=status;
	}
	public String getInspectionTask()
	{ return inspectionTask;}
	
	public float getInspectionPrice()
	{ return price;}
	
	public boolean getInspectionStatus()
	{ return status;}
	
	public void setStatus(boolean status)
	{
		this.status=status;
	}
	
	

}
