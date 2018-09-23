
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

interface Operation{
    void execute(Player player);
}

public class happenings {
    
    ArrayList<Operation> words = new ArrayList<Operation>();
    
    happenings() {
        words.add((player) -> hello(player));
        words.add((player) -> pole(player));
        words.add((player) -> getPlayerInfo(player));
        words.add((player) -> getExperience(player));
    }
    
    public static void hello(Player player) {
        System.out.println("Hello");
    }
    
    
    public static void pole(Player player) {
        Scanner in = new Scanner(System.in);
        var quizWordsList = new quizWords();
        Random rnd = new Random();
        while(true)
        {
            String quizWord = quizWordsList.words.get(rnd.nextInt(quizWordsList.words.size()));
            StringBuilder answerWord = new StringBuilder();
            for (int i=0; i<quizWord.length(); i++)
                answerWord.append(".");
            System.out.println("Добро пожаловать на телешоу Поле Чудес");
            String inputMain = in.next().toString();
            String inputMainLower = inputMain.toLowerCase();
            if( inputMainLower.equals("exit"))
            {
                System.out.println("bye");
                break;
            }
            while (true)
            {
                System.out.println(answerWord);
                System.out.println("Букву назовите");
                String input = in.next().toString();
                String inputLower = input.toLowerCase();
                if( inputLower.equals("exit"))
                {
                    System.out.println("bye");
                    break;
                }
                if (inputLower.length()!=1)
                    System.out.println("Да это же не буква!");
                else
                {
                    if (quizWord.contains(inputLower))
                    {
                        System.out.println("Есть такая буква!!!");
                        for(int i=0;i<quizWord.length();i++)
                            if(quizWord.charAt(i)==inputLower.charAt(0))
                                answerWord.setCharAt(i, inputLower.charAt(0));
                    }
                    else
                    {
                        System.out.println("А здесь такой буквы нету");
                    }
                }
            }
        }
        System.out.println("End Of Conversartion");
        in.close();
    }
    
    public static void getPlayerInfo(Player player) {
        System.out.println("Health="+player.health);
        System.out.println("level="+player.level);
        System.out.println("experience="+player.experience);
    }
    
    public static void getExperience(Player player) {
        player.experience += 10;
    }
    
    public static void testFight(Player player) {
        System.out.println("На вас напал медведь");
        player.health -= 10;
    }
    
    public static void testQuestion(Player player) {
        Scanner in = new Scanner(System.in);
        System.out.println("назови число");
        String input = in.next().toString().toLowerCase();
        if (input.equals("42"))
            player.experience+=10;
        player.health -= 10;
        in.close();
    }

}