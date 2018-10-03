
import java.util.Random;

public class Core {

	public static void start(Player player) {
		EventList eventsList = new EventList(player);
		Random rnd = new Random();
		while (eventsList.Count() != 0 && player.isAlive())
		{
			int nextEvent = rnd.nextInt(eventsList.events.size());
			System.out.println(eventsList.events.get(nextEvent).getEventName());
			eventsList.events.get(nextEvent).execute(player);
			eventsList.Remove(nextEvent);
			System.out.println("End of event");
	
		}
		//in.close();
        System.out.println("Dungeon completed!");
	}
}