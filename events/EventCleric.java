import java.util.List;
import java.util.Random;

public class EventCleric extends Event {

    private Parser parser;
    public List<Question> listQuest;
    public int questionCounter = 0;
    private boolean isDisposable = false;
    private Player player;
    private Random rnd = new Random();

    EventCleric(Player player) {
        super(player, false);
        this.parser = new Parser("data/ClericDialog.txt");
        this.listQuest = this.parser.toListQuestions();
        this.player = player;
    }

    public void getInfo() {
        player.sendMsg("\n You see a young cleric.\n Hello, stranger i can heal you, but firstly answer my question");
    }

    public void start() {
        questionCounter = rnd.nextInt(listQuest.size());
        player.sendMsg(listQuest.get(questionCounter).question);
    }

    public void checkPlayerAnswer(String answer) {
        if (listQuest.get(questionCounter).answers.contains(answer)) {
            player.heal(50);
            player.sendMsg("Yes, this is good answer, i heal you");
        } else {
            player.sendMsg("NO, STUPID MAN");
        }
        super.end();
    }

    public void nextQuestion() {
        {
            player.sendMsg("hui");
        }
    }

    public boolean checkDispose() {
        return isDisposable;
    }

}
