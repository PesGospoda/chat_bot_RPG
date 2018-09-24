
import java.util.Scanner;

public class eventCycle {
	
	public static void main(String[] args) 
	{
		Player player = new Player();
		Scanner in = new Scanner(System.in);
		eventList eventsList = new eventList();
		while (true)
		{
			System.out.println("print index");
			String inputMain = in.next().toString();
			String inputMainLower = inputMain.toLowerCase();
			if( inputMainLower.equals("exit"))
			{
					System.out.println("bye");
					break;
			}
			else
			{
				eventsList.events.get(0).startEvent.execute(player);
			}
	
		}
	}
}