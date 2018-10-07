import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestEvent extends EventAbstract {
	
	private String eventName;
	private Parser parser;
	
	TestEvent(){
		this.eventName = "TestEvent";
		this.parser = new Parser("testDialogs.txt");
	}
		
	
	public void execute(Player player)
	{
		Scanner input = new Scanner(System.in);
		List<Question> listQuest = null;

		listQuest = parser.toListQuestions();

		for(int i =0; i<listQuest.size();i++)
		{
			System.out.println(listQuest.get(i).question);
			String answer = input.next();
			if (listQuest.get(i).answers.contains(answer))
				System.out.println("Right!");
			else
				{
				System.out.println("Wrong!");
			}
		}
	}
	
	public String getEventName()
	{
		return eventName;
	}

}
