package test;

import java.util.Random;
import java.util.Scanner;

public class MainQuest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		happenings happen = new happenings();
		TechnicalCommands technical = new TechnicalCommands();
		Player player = new Player();
		//Random rnd = new Random();
		while (true)
		{
			System.out.println("print index");
			String inputMain = in.next().toString();
			String inputMainLower = inputMain.toLowerCase();
			if (technical.technicalCommands.get(inputMainLower)!=null)
				technical.technicalCommands.get(inputMainLower).execute(player);
			if( inputMainLower.equals("exit"))
			{
					System.out.println("bye");
					break;
			}
			if (inputMainLower.equals("0"))
				happen.words.get(Integer.parseInt(inputMain)).execute(player);
			if (inputMainLower.equals("1"))
				happen.words.get(Integer.parseInt(inputMain)).execute(player);
			if (inputMainLower.equals("2"))
				happen.words.get(Integer.parseInt(inputMain)).execute(player);
			if (inputMainLower.equals("3"))
				happen.words.get(Integer.parseInt(inputMain)).execute(player);
		}
		System.out.println("End Of Conversartion");
		in.close();
	}

}
