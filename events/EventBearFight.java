import java.util.Random;


public class EventBearFight extends Event {
    private int bearAttack;
    private int bearHP;
    private Random rnd;
    private Player player;

    EventBearFight(Player player) {
        super(player, true);
        this.rnd = new Random();
        this.bearHP = 300;
        this.player = player;
    }

    public void getInfo() {
        player.sendMsg("\n You meet bear.\n fight or die (1 - move left, 2 - move right, 3 - attack)");
    }

    public void start() {
        bearAttack = rnd.nextInt(3) + 1;
        player.sendMsg("Bear is attacking, defend!!!");
        ;
    }

    public void checkPlayerAnswer(String playerAttack) {
        if (playerAttack.charAt(0) == '!') {//надо спросить про это, не трожь пока
            super.checkPlayerAnswer(playerAttack);
            return;
        }
        if (playerAttack.equals(Integer.toString(bearAttack))) {
            bearAttack = rnd.nextInt(3) + 1;
            player.sendMsg("tie");
        }
        if (playerAttack.equals("2") & Integer.toString(bearAttack).equals("3") |
                playerAttack.equals("1") & Integer.toString(bearAttack).equals("2") |
                playerAttack.equals("3") & Integer.toString(bearAttack).equals("1")) {
            bearAttack = rnd.nextInt(3) + 1;
            bearHP -= 100;
            player.sendMsg("you hit the bear");
        }
        if (playerAttack.equals("3") & Integer.toString(bearAttack).equals("2") |
                playerAttack.equals("2") & Integer.toString(bearAttack).equals("1") |
                playerAttack.equals("1") & Integer.toString(bearAttack).equals("3")) {
            bearAttack = rnd.nextInt(3) + 1;
            player.getDamage(10);
            player.sendMsg("bear hits you");
        }
        nextQuestion();
    }

    public void nextQuestion() {
        if (bearHP <= 0) {
            bearHP = 300;
            end();
        } else
            player.sendMsg("bear attacks again");
    }

    @Override
    public void end() {
        player.nextEvent();
    }

}
