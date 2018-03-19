package integration;

public class InspectionTaskDTO {
	String inspectionTask;
	float price;
	public InspectionTaskDTO(String inspectionTask, float price )
	{
		this.inspectionTask = inspectionTask;
		this.price = price;
	}
	public String getInspectionTask()
	{ return inspectionTask;}
	
	public float getInspectionPrice()
	{ return price;}
	
	

}
