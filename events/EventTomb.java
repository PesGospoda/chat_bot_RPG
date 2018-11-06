import java.util.List;


public class EventTomb extends Event {
    private List<Question> listQuest;
    private int questionCounter;

    EventTomb(Player player) {
        super(player, true);
        this.listQuest = new Parser("data/ArakanDialog.txt").toListQuestions();
        questionCounter = 0;
    }

    public void getInfo() {
        player.sendMsg("\n You are in the tomb of the Great Arakan.\n Answer questions or die...\n" +
                "(for each wrong answer you getEvent damage)");
    }

    public List<Question> getListQuest() {
        return listQuest;
    }

    public int getQuestionCounter() {
        return questionCounter;
    }

    public void start() {
        player.sendMsg("Welcome in Arakan tomb, mortal ");
        player.sendMsg(listQuest.get(0).question);
    }

    public void checkPlayerAnswer(String answer) {
        if (answer.charAt(0) == '!') {//надо спросить про это, не трожь пока
            super.checkPlayerAnswer(answer);
            return;
        }
        if (listQuest.get(questionCounter).answers.contains(answer)) {
            player.sendMsg("Good, next question");
            nextQuestion();
        } else {
            player.sendMsg("NO! Wrong answer. Catch fireball");
            player.getDamage(20);
            //player.sendMsg(listQuest.get(questionCounter).question);
            nextQuestion();
        }
    }

    public void nextQuestion() {
        questionCounter += 1;
        if (questionCounter < listQuest.size())
            player.sendMsg(listQuest.get(questionCounter).question);
        else {
            super.end();
        }
    }

}

