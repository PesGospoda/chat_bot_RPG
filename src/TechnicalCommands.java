
import java.util.HashMap;
import java.util.Map;

public class TechnicalCommands {
	
	static Map<String, Operation> technicalCommands = new HashMap<String, Operation>();//?� ����� ������ �� ����� �� �� ����� ����� ��� � ������ �� ��� � �� ��������
	
	TechnicalCommands(){
		technicalCommands.put("!help", (player) -> help(player));
	}

	public static void help(Player player) {
		System.out.println("������, �� ���������� � ���� Test");
		System.out.println("����� ������ ���� �����");
		System.out.println(technicalCommands.keySet());
	}

}
