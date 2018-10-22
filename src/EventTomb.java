import java.util.List;


public class EventTomb extends Event {
    private List<Question> listQuest;
    private int questionCounter;

    EventTomb(Player player) {
        super(player, true);
        this.listQuest = new Parser("ArakanDialog.txt").toListQuestions();
        questionCounter = 0;
    }

    public void getInfo() {
        player.sendMsg("\n You are in the tomb of the Great Arakan.\n Answer questions or die...\n" +
                "(for each wrong answer you getEvent damage)");
    }

    public void start() {
        player.sendMsg("Добро пожаловать, смертный");
        player.sendMsg(listQuest.get(0).question);
    }

    public void checkPlayerAnswer(String answer) {
        if (answer.charAt(0) == '!') {//надо спросить про это, не трожь пока
            super.checkPlayerAnswer(answer);
            return;
        }
        if (listQuest.get(questionCounter).answers.contains(answer)) {
            player.sendMsg("Хорошо след вопрос");
            nextQuestion();
        } else {
            player.sendMsg("нет, лови фаербол в лицо и поробуй попробуй еще");
            player.getDamage(50);
            player.sendMsg(listQuest.get(questionCounter).question);
        }
    }

    public void nextQuestion() {
        questionCounter += 1;
        if (questionCounter < listQuest.size())
            player.sendMsg(listQuest.get(questionCounter).question);
        else {
            end();
        }
    }

    public void end() {
        player.sendMsg("You complete this tomb of dungeon");
        player.nextEvent();
    }
}

