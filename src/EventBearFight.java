import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Random;


public class EventBearFight extends EventAbstract {
    private int bearAttack;
    private int bearHP;
    private Random rnd;
    private boolean isDisposable = false;
    private Player player;

    EventBearFight(Player player) {
        super(player, true);
        this.rnd = new Random();
        this.bearHP = 300;
        this.player = player;
    }

    public String getInfo() {
        return "\n You meet bear.\n fight or die (1 - move left, 2 - move right, 3 - attack)";
    }

    public String enter(){
        bearAttack = rnd.nextInt(3) + 1;
        return "Bear is attacking, defend!!!";
    }

    public String checkPlayerAnswer(String playerAttack){

        if (playerAttack.equals(Integer.toString(bearAttack)))
        {
            bearAttack = rnd.nextInt(3) + 1;
            return("tie");
        }
        if (playerAttack.equals("2") & Integer.toString(bearAttack).equals("3") |
                playerAttack.equals("1") & Integer.toString(bearAttack).equals("2")|
                playerAttack.equals("3") & Integer.toString(bearAttack).equals("1"))
        {
            bearAttack = rnd.nextInt(3) + 1;
            bearHP -= 100;
            return("you hit the bear");
        }
        if (playerAttack.equals("3") & Integer.toString(bearAttack).equals("2")|
                playerAttack.equals("2") & Integer.toString(bearAttack).equals("1")|
                playerAttack.equals("1") & Integer.toString(bearAttack).equals("3"))
        {
            bearAttack = rnd.nextInt(3) + 1;
            player.getDamage(10);
            return("bear hits you");
        }
        return("bear hits you");
    }

    public String nextQuestion(){
        if (bearHP<=0) {
            bearHP = 300;
            return ("!exit");
        }
        else
            return("bear attacks again (1 - move left, 2 - move right, 3 - attack)");
    }

}
