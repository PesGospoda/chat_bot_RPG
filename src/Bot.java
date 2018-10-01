import java.util.ArrayList;

public class Bot {
    public Bot(ArrayList<Question> text) {
        this.questions = text;
    }
    public ArrayList<Question> questions;
    private int currentQuestion = 0;

    public boolean NotEnd(){return this.questions.size() != this.currentQuestion + 1;}

    public String NextQuestion(){
        currentQuestion++;
        return questions.get(currentQuestion).question;
    }

    //public Boolean IsTrueAnswer(String answer){
    //    return answer.equals(questions.get(currentQuestion).answer);
    }

