import java.util.ArrayList;

public class Question {
    public String question;
    public ArrayList<String> answers = new ArrayList<>();

    Question(String question) {
        this.question = question;
    }

    public boolean isTrueAnswer(String answ) {
        return answers.contains(answ);
    }
}
