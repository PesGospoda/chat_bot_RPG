import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public   Map<Integer,Question> dictionary = new HashMap<Integer,Question>();

    public Parser(String file) {
        try(FileReader reader = new FileReader(file))
        {
            BufferedReader readerLine = new BufferedReader(reader);
            Question newQuestion = new Question();
            newQuestion.question =  readerLine.readLine();
            newQuestion.answer = readerLine.readLine();

            while (newQuestion.question != null && newQuestion.answer != null){
                this.dictionary.put(dictionary.size() + 1, newQuestion );
                newQuestion = new Question();
                newQuestion.question =  readerLine.readLine();
                newQuestion.answer = readerLine.readLine();
            }

        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public Map<Integer, Question> GetDictionary()
    {
        return this.dictionary;
    }
}
