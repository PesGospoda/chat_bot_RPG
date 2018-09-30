import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {

    //private BufferedReader readLine;

    //public Parser(String file) {
    //    try
    //    {
    //        FileReader reader = new FileReader(file);
    //        BufferedReader readLine = new BufferedReader(reader);
    //    }
    //    catch(IOException ex)
    //    {
    //        System.out.println(ex.getMessage());
    //    }

    //}

    public ArrayList<Question> MakeQuestions(String file) throws IOException {
        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader readLine = new BufferedReader(reader);
        var result = new ArrayList<Question>();
        String line;
        int questionIndex = -1;
        while((line = readLine.readLine())!=null)
        {
            if (line.charAt(0)=='#')
            {
                questionIndex +=1;
                result.add(new Question());
                result.get(questionIndex).question = line.substring(1);
            }
            else
            {
                result.get(questionIndex).answers.add(line.substring(1));
            }
        }
        return result;
    }
}
