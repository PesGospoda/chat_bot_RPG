import java.util.ArrayList;

public class EventList {
	
	ArrayList<EventAbstract> events = new ArrayList<EventAbstract>();
	
	EventList(Player player)
	{
		//events.add(new EventGrobnica(pl));
        events.add(new EventGrobnica());
        //events.add(new PoleChudes());
		events.add(new TestEvent());
	}

	public void Remove(int index){
	    events.remove(index);
    }

	public int Count(){return events.size();}
	
}
