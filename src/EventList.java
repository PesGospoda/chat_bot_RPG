import java.util.ArrayList;
import java.util.List;

public class EventList {

	List<EventAbstract> events = new ArrayList<EventAbstract>();

	EventList(Player player)
	{
		//events.add(new Tomb());
		events.add(new PoleChudes("hello"));
		//events.add(new TestEvent());
	}

	public void Remove(int index){
		events.remove(index);
	}

	public int Count(){return events.size();}

}
