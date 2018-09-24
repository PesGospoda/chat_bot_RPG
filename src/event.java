interface Operation{
    void execute(Player player);
}


public class event {
	
	public String eventName;
	public Operation execute;
	public Parcer parcer;
	
	Event(String eventName, Operation operation, Parcer parcer)
	{
		this.eventName = eventName;
		this.execute = operation;
		this.parcer = Parcer;
	}
	
	Event(String eventName, Operation operation)
	{
		this.eventName = eventName;
		this.execute = operation;
	}

}

