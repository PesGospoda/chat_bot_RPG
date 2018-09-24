package chat_bot_RPG;

import java.util.Scanner;

public class eventCycle {
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		eventList events = new eventList();
		while (true)
		{
			System.out.println("print index");
			String inputMain = in.next().toString();
			String inputMainLower = inputMain.toLowerCase();
			if (technical.technicalCommands.get(inputMainLower)!=null)
				technical.technicalCommands.get(inputMainLower).execute(player);
			if( inputMainLower.equals("exit"))
			{
					System.out.println("bye");
					break;
			}
			else
			{
				eventList.get(0).startEvent.execute();
			}
	
		}
	}
}