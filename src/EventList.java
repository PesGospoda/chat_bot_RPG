import java.util.ArrayList;

public class EventList {

	ArrayList<EventAbstract> events = new ArrayList<>();

	EventList(Player player)
	{
		//events.add(new EventGrobnica());
		events.add(new PoleChudes("hello"));
		//events.add(new TestEvent());
	}

	public void Remove(int index){
		events.remove(index);
	}

	public int Count(){return events.size();}

}
