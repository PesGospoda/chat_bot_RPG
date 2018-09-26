import java.util.ArrayList;

public class eventList {
	
	ArrayList<eventAbstract> events = new ArrayList<eventAbstract>();
	
	eventList(Player pl)
	{
		events.add(new eventGrobnica(pl));
        events.add(new eventGrobnica(pl));
	}

	public void Remove(int index){
	    events.remove(index);
    }

	public int Count(){return events.size();}
	
}
