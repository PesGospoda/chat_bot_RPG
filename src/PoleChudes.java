import java.util.Random;
import java.util.Scanner;

public class PoleChudes extends EventAbstract {
	
	private String eventName = "PoleChudes";
	
	public String getEventName()
	{
		return eventName;
	}
	
	public void execute(Player player)
	{
		Scanner input = new Scanner(System.in);
        var quizWordsList = new QuizWords();
        Random rnd = new Random();
        while(true)
        {
            String quizWord = quizWordsList.words.get(rnd.nextInt(quizWordsList.words.size()));
            StringBuilder answerWord = new StringBuilder();
            for (int i=0; i<quizWord.length(); i++)
                answerWord.append(".");
            System.out.println("Welcome on show Pole Chudes");
            String inputMain = input.next().toString();
            String inputMainLower = inputMain.toLowerCase();
            if( inputMainLower.equals("exit"))
            {
                System.out.println("bye");
                break;
            }
            while (true)
            {
                System.out.println(answerWord);
                System.out.println("say letter");
                String inputLower = input.next().toString().toLowerCase();
                //String inputLower = input.toLowerCase();
                if( inputLower.equals("exit"))
                {
                    System.out.println("bye");
                    break;
                }
                if (inputLower.length()!=1)
                    System.out.println("this is not a letter");
                else
                {
                    if (quizWord.contains(inputLower))
                    {
                        System.out.println("good");
                        for(int i=0;i<quizWord.length();i++)
                            if(quizWord.charAt(i)==inputLower.charAt(0))
                                answerWord.setCharAt(i, inputLower.charAt(0));
                    }
                    else
                    {
                        System.out.println("there is no such letter");
                    }
                }
            }
        }
        //input.close();
	}
}
