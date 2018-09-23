package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TechnicalCommands {
	
	static Map<String, Operation> technicalCommands = new HashMap<String, Operation>();
	
	TechnicalCommands(){
		technicalCommands.put("!playerinfo", (player) -> getPlayerInfo(player));
		technicalCommands.put("hesoyam", (player) -> hesoyam(player));
		technicalCommands.put("!help", (player) -> help(player));
	}
	
	public static void getPlayerInfo(Player player) {
		System.out.println("Health="+player.health);
		System.out.println("level="+player.level);
		System.out.println("experience="+player.experience);
	}
	public static void hesoyam(Player player) {
		player.health = 100;
		player.experience = 10000;
		player.level = 100500;
	}
	
	public static void help(Player player) {
		System.out.println("Привет, ты находишься в игре Test");
		System.out.println("здесь должна быть хелпа");
		System.out.println(technicalCommands.keySet());
	}

}
