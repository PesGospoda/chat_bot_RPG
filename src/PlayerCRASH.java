package test;

import java.util.Scanner;

public class Player {
	int health;
	int level;
	int experience;
	private final Scanner input;

	public  String getAnswer() {
		return input.nextLine();
	}

	Player(){
		this.health = 100;
		this.level = 1;
		this.experience = 0;
		this.input = new Scanner(System.in);
	}
	public void printInfo()
	{
		System.out.println("Health="+health);
		System.out.println("level="+level);
		System.out.println("experience="+experience);
	}

}
