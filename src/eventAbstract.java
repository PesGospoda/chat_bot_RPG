interface Operation{
    void execute(Player player);
}


public abstract class eventAbstract {
	
	public String eventName;
	public abstract void Execute(Player player);
	public abstract String GetEventName();
	


}

