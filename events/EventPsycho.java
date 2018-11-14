import java.util.List;
import java.util.Random;

public class EventPsycho extends Event {

    private Parser parser;
    public List<Question> listQuest;
    public int questionCounter = 0;
    private boolean isDisposable = false;
    private Player player;
    private Random rnd = new Random();

    EventPsycho(Player player) {
        super(player, false);
        this.parser = new Parser("data/PsychoDialog.txt");
        this.listQuest = this.parser.toListQuestions();
        this.player = player;
    }

    public void getInfo() {
        player.sendMsg("\n You see a strange man with knife in his hand.\n Hey YoU Answer my question or i stab you with this sharp KNIFE");
    }

    public void start() {
        questionCounter = rnd.nextInt(listQuest.size());
        player.sendMsg(listQuest.get(questionCounter).question);
    }

    public void checkPlayerAnswer(String answer) {
        if (listQuest.get(questionCounter).answers.contains(answer)) {
            player.upExperience(10);
            player.sendMsg("AAARRRGGHHHH IT's A RIGHT ANSWER!!!!");
        } else {
            player.getDamage(20);
            player.sendMsg("AHAHAHA NOO YO'RE NOT AS CRAZY AS I AM!!!!!");
        }
        super.end();
    }

    public void nextQuestion() {
        {
            player.sendMsg("!exit");
        }
    }

    public boolean checkDispose() {
        return isDisposable;
    }

}

