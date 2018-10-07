import java.util.HashMap;
import java.util.Map;

interface Operation{
    void execute();
}

public class TechnicalCommands {
    public static Map<String, Operation> listOfCommands = new HashMap<String, Operation>();

    TechnicalCommands(Player player){
        listOfCommands.put("!playerinfo", () -> getPlayerInfo(player));
        listOfCommands.put("!help", () -> help(player));
    }

    private static void getPlayerInfo(Player player) {
        System.out.println("Health="+player.getHealth());
    }

    private static void help(Player player) {
        System.out.println("hello you're in game");
        System.out.println("there might be help");
        System.out.println(listOfCommands.keySet());
    }
}
