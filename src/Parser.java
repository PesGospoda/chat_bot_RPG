import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {

    public ArrayList<Question> makeQuestions(String file) throws IOException {
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
                System.out.println(line);
                result.get(questionIndex).answers.add(line.substring(1));
            }
        }
        return result;
    }
}
