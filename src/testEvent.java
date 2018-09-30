import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class testEvent extends eventAbstract{
	
	private String eventName;
	private Parser parser;
	
	testEvent(){
		this.eventName = "testEvent";
		this.parser = new Parser();
	}
		
	
	public void Execute()
	{
		Scanner input = new Scanner(System.in);
		ArrayList<Question> listQuest = null;
		try {
			listQuest = parser.MakeQuestions("testDialog.txt");
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
				System.out.println("Wrong!");
		}
	}
	
	public String GetEventName()
	{
		return eventName;
	}

}
