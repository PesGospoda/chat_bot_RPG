import java.util.List;

public class EventQuiz extends Event {

    private List<Question> listQuest;
    private int questionCounter;

    EventQuiz(Player player) {
        super(player, true);
        this.listQuest = new Parser("MageQuizDialog.txt").toListQuestions();
        questionCounter = 0;
    }

    public void getInfo() {
        player.sendMsg("Answer questions or die...\n" +
                "(for each wrong answer you getEvent damage)");
    }

    public void start() {
        player.sendMsg("Добро пожаловать, смертный \n You see an old man, he looks wise.");
        player.sendMsg(listQuest.get(0).question);
    }

    public void checkPlayerAnswer(String answer) {
        if (answer.charAt(0) == '!') {//надо спросить про это, не трожь пока 
            super.checkPlayerAnswer(answer);
            return;
        }
        if (listQuest.get(questionCounter).answers.contains(answer)) {
            player.sendMsg("Yes, this is good answer");
        } else {
            player.sendMsg("NO, STUPID MAN");
            player.getDamage(10);
        }
        nextQuestion();
    }

    public void nextQuestion() {
        questionCounter += 1;
        if (questionCounter < listQuest.size())
            player.sendMsg(listQuest.get(questionCounter).question);
        else {
            end();
        }
    }

    @Override
    public void end() {
        player.sendMsg("You complete this tomb of dungeon");
        player.nextEvent();
    }
}
