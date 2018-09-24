package chat_bot_RPG;

import java.util.ArrayList;

public class eventList {
	
	ArrayList<Object> events = new ArrayList<Object>();
	
	eventList()
	{
		events.add(new Event("testEvent", (player) -> testEvent(player)));
	}
	
	public void testEvent(Player player)
	{
		print("Hello");
	}

}
