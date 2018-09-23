import java.util.Scanner;

public class Player {
    public Player() {
        this.score = 0;
        this.health = 100;
    }

    private int score;
    private int health;

    private final Scanner input = new Scanner(System.in);

    public  String getAnswer() {
        return input.nextLine();
    }

    public Boolean IsAlive(){ return this.health > 0; }

    public int getDamage(int damage){
        health -= damage;
        return health;
    }
}
