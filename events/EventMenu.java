import java.util.List;


public class EventMenu extends Event {
    //private List<Question> listQuest;
    private int questionCounter;

    EventMenu(Player player) {
        super(player, true);
        //this.listQuest = new Parser("ArakanDialog.txt").toListQuestions();
        //questionCounter = 0;
    }

    public void getInfo() {
        player.sendMsg("\n You are in the tomb of the Great Arakan.\n Answer questions or die...\n" +
                "(for each wrong answer you getEvent damage)");
    }

    public void start() {
        player.sendMsg("you're entering the vault\n print easy for easy dungeon\n print shop for shop\n print !help for help");
        //player.sendMsg(listQuest.get(0).question);
    }

    public void checkPlayerAnswer(String answer) {
        if (answer.charAt(0) == '!') {
            super.checkPlayerAnswer(answer);
            return;
        }
        if (answer.equals("easy"))
        {
            player.sendMsg("enterting easy dungeon");
            player.makeEasyDungeon();
            end();
        }
        if (answer.equals("shop"))
        {
            player.sendMsg("no shop");
        }
    }

    public void nextQuestion() {
        questionCounter += 1;
    }

    public void end() {
        //player.sendMsg("You complete this tomb of dungeon");
        player.nextEvent();
    }
}