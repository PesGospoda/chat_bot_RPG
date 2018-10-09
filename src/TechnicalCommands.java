import java.util.HashMap;
import java.util.Map;

interface Operation {
    void execute();
}

public class TechnicalCommands {
    public Map<String, Operation> listOfCommands = new HashMap<>();

    public TechnicalCommands(Player player) {
        listOfCommands.put("!playerInfo", () -> print(player.getInfo()));
        listOfCommands.put("!help", () -> print(help()));
        listOfCommands.put("!helpEvent", () -> print(player.getCurrentEvent().getInfo()));
        listOfCommands.put("!exit", () -> {print(exit()); System.exit(0); });
}

    private void print(String string){
        System.out.println(string);
    }

    private String exit(){
        return "\nYou didn't think you could get away alive?\n" +
                "AhAHAhAHaha" +
                "\n(You get damage - 99999999, and dead)";
    }

    private String help() {
        return "\nHello you're in game" +
                "\nthere magics might be help\n" +
                this.listOfCommands.keySet();
    }
}
