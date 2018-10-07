import java.util.Scanner;

public class Player {

    public Player() {
        this.score = 0;
        this.health = 100;
    }

    private int score;
    private int health;
    private TechnicalCommands techCommands = new TechnicalCommands(this);

    private final Scanner input = new Scanner(System.in);

    public  String getAnswer() {
        String answer;
        while (true)
        {
            answer = input.nextLine();
            if (techCommands.listOfCommands.get(answer)!=null)
                techCommands.listOfCommands.get(answer).execute();
            else
                break;
        }
        return answer;
    }

    public Boolean isAlive(){ return this.health > 0; }

    public int getDamage(int damage){
        health -= damage;
        return health;
    }

    public int getHealth(){
        return this.health;
    }
}
