import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {

    private BufferedReader readLine;

    public Parser(String file) {
        try
        {
            FileReader reader = new FileReader(file);
            readLine = new BufferedReader(reader);
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public ArrayList<Question> toListQuestions()
    {
        var result = new ArrayList<Question>();
        Question newQuestion = new Question();
        try {
            newQuestion.question = readLine.readLine();
            newQuestion.answer = readLine.readLine();
            result.add(newQuestion);
            while (newQuestion.question != null && newQuestion.answer != null) {
                result.add(newQuestion);
                newQuestion = new Question();
                newQuestion.question = readLine.readLine();
                newQuestion.answer = readLine.readLine();
            }
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
