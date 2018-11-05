import java.util.HashMap;
import java.util.Map;

interface Operation {
    void execute();
}

public class TechnicalCommands {
    private Map<String, Operation> listOfCommands = new HashMap<>();


    public TechnicalCommands(Player player) {
        listOfCommands.put("!playerinfo", player::getInfo);
        listOfCommands.put("!help", () -> player.sendMsg(help()));
        listOfCommands.put("!helpevent", () -> player.getCurrentEvent().getInfo());
        //listOfCommands.put("!exit", () -> player.getBot().listOfPlayersInDungeon.remove(player.getPlayerID()));
        listOfCommands.put("!nextevent", player::nextEvent);
    }

    public Boolean contains(String command) {
        return listOfCommands.get(command) != null;
    }

    public void doOperation(String key) {
        listOfCommands.get(key).execute();
    }

    private String help() {
        return "\nHello you're in game" +
                "\nthere magic might be help\n\n" + "```" +
                this.listOfCommands.keySet() + "```";
    }
}
