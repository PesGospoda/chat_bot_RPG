
import java.util.Random;
import java.util.Scanner;

public class eventCycle {
	
	public static void main(String[] args) 
	{
		Player player = new Player();
		Scanner in = new Scanner(System.in);
		eventList eventsList = new eventList();
		Random rnd = new Random();
		while (true)
		{
			int nextEvent = rnd.nextInt(eventsList.events.size());
			String inputMain = in.next().toString();
			String inputMainLower = inputMain.toLowerCase();
			if( inputMainLower.equals("exit"))
			{
					System.out.println("bye");
					break;
			}
			else
			{
				System.out.println(nextEvent);
				System.out.println(eventsList.events.get(nextEvent));
				System.out.println(eventsList.events.get(nextEvent).GetEventName());
				eventsList.events.get(nextEvent).Execute(player);
			}
			System.out.println("End of event");
	
		}
		in.close();
	}
}