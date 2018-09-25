
import java.util.ArrayList;

public class eventList {
	
	ArrayList<eventAbstract> events = new ArrayList<eventAbstract>();
	
	eventList()
	{
		events.add(new testEvent());
		events.add(new poleChudes());
	}
	
}
