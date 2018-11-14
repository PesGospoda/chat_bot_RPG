import java.util.List;


public class EventMenu extends Event {
    EventMenu(Player player) {
        super(player, true);
    }

    public void getInfo() {
        player.sendMsg("\n You are in the tomb of the Great Arakan.\n Answer questions or die...\n" +
                "(for each wrong answer you getEvent damage)");
    }

    public void start() {
        player.sendMsg("you're entering the vault\n print easy for easy dungeon\n print medium for medium dungeon \n print shop for shop\n print !help for help");
    }

    public void checkPlayerAnswer(String answer) {
        if (answer.charAt(0) == '!') {
            super.checkPlayerAnswer(answer);
            return;
        }
        if (answer.equals("easy")) {
            player.sendMsg("enterting easy dungeon");
            player.makeEasyDungeon();
        }
        if (answer.equals("medium")) {
            player.sendMsg("enterting medium dungeon");
            player.makeMediumDungeon();
        }
        if (answer.equals("shop")) {
            player.sendMsg("will be soon");
        }
    }

    public void nextQuestion() {
    }

}