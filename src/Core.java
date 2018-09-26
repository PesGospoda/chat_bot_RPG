
import java.util.Random;
import java.util.Scanner;

public class Core {
	
	public static void start()
	{
		Player player = new Player();
		eventList eventsList = new eventList(player);
		Random rnd = new Random();
		while (eventsList.Count() != 0 && player.IsAlive())
		{
			int nextEvent = rnd.nextInt(eventsList.events.size());
			System.out.println(eventsList.events.get(nextEvent).GetEventName());
			eventsList.events.get(nextEvent).Execute();
			eventsList.Remove(nextEvent);
			System.out.println("End of event");
	
		}
		//in.close();
        System.out.println("Подземелье пройдено!");
	}
}