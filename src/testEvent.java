
public class testEvent extends eventAbstract{
	
	private String eventName;
	
	testEvent(){
		this.eventName = "testEvent";
	}
		
	
	public void Execute(Player player)
	{
		System.out.println(eventName);
	}
	
	public String GetEventName()
	{
		return eventName;
	}

}
