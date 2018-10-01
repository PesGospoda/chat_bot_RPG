import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestEvent extends EventAbstract {
	
	private String eventName;
	private Parser parser;
	
	TestEvent(){
		this.eventName = "TestEvent";
		this.parser = new Parser();
	}
		
	
	public void execute(Player player)
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Question> listQuest = null;
		try {
			listQuest = parser.makeQuestions("testDialogs.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i =0; i<listQuest.size();i++)
		{
			System.out.println(listQuest.get(i).question);
			String answer = input.next();
			if (listQuest.get(i).answers.contains(answer))
				System.out.println("Right!");
			else
				{
				System.out.println("Wrong!");
				player.getDamage(10);
			}
		}
	}
	
	public String getEventName()
	{
		return eventName;
	}

}
