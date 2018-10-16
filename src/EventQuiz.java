import java.util.List;

public class EventQuiz extends  EventAbstract{

    private Parser parser;
    public List<Question> listQuest;
    public int questionCounter = 0;
    private boolean isDisposable = true;

    EventQuiz() {
        this.parser = new Parser("MageQuizDialog.txt");
        this.listQuest = this.parser.toListQuestions();
    }

    public String getInfo() {
        return "\n You see an old man, he looks wise.\n Answer questions or die...\n" +
                "(for each wrong answer you get damage)";
    }

    public String enter(){
        return listQuest.get(0).question;
    }

    public String checkPlayerAnswer(String answer){
        if (listQuest.get(questionCounter).answers.contains(answer)) {
            questionCounter +=1;
            return ("Yes, this is good answer");
        }
        else
        {
            questionCounter += 1;
            return ("NO, STUPID MAN");
        }
    }

    public String getCurrentQuestion(){
        if (questionCounter<listQuest.size())
            return listQuest.get(questionCounter).question;
        else
        {
            return("!exit");
        }
    }

    public boolean checkDispose(){
        return isDisposable;
    }
}
