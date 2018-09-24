
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TechnicalCommands {
	
	static Map<String, Operation> technicalCommands = new HashMap<String, Operation>();//?я понял почему не робит но не понял зачем так и почему то там а не отдельно
	
	TechnicalCommands(){
		technicalCommands.put("!help", (player) -> help(player));
	}

	public static void help(Player player) {
		System.out.println("Привет, ты находишься в игре Test");
		System.out.println("здесь должна быть хелпа");
		System.out.println(technicalCommands.keySet());
	}

}
