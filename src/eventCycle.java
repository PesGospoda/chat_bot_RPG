
import java.util.Scanner;

public class eventCycle {
	
	public static void main(String[] args) 
	{
		Player player = new Player();
		Scanner in = new Scanner(System.in);
		eventList eventsList = new eventList();
		while (true)
		{
			String inputMain = in.next().toString();
			String inputMainLower = inputMain.toLowerCase();
			if( inputMainLower.equals("exit"))
			{
					System.out.println("bye");
					break;
			}
			else
			{
				System.out.println(eventsList.events.get(0));
				System.out.println(eventsList.events.get(0).GetEventName());
				//System.out.println(a);
				//System.out.println(eventsList.events.get(0).eventName);
				eventsList.events.get(0).Execute(player);
				//System.out.println(eventsList.events.get(0).eventName);
			}
	
		}
		in.close();
	}
}