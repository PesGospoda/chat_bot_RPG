import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Parser {
    private BufferedReader readLine;

    public Parser(String file) {
        FileReader reader = null;
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        readLine = new BufferedReader(reader);
    }

    public ArrayList<Question> toListQuestions() {
        var result = new ArrayList<Question>();
        String line;
        int questionIndex = -1;
        try {
            while ((line = readLine.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    questionIndex++;
                    result.add(new Question(line.substring(1)));
                } else if (line.charAt(0) == '$') {
                    if (result.size() == 0)
                        throw new IOException();
                    result.get(questionIndex).answers.add(line.substring(1));
                }
            }
        }catch (IOException e){
            e.getMessage();
        }

        return result;
    }
}
