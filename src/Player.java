import java.util.Scanner;

public class Player {

    public Player() {
        this.score = 0;
        this.health = 100;
    }

    private int score;
    private int health;
    private TechnicalCommands techCommands = new TechnicalCommands(this);

    public void setCurrentEvent(EventAbstract currentEvent) {
        this.currentEvent = currentEvent;
    }

    public EventAbstract getCurrentEvent() {
        return currentEvent;
    }

    private EventAbstract currentEvent;

    private final Scanner input = new Scanner(System.in);

    public String getAnswer() {
        String answer;
        while (true) {
            answer = input.nextLine();
            if (answer.charAt(0) == '!')
                if (techCommands.listOfCommands.get(answer) != null)
                    techCommands.listOfCommands.get(answer).execute();
                else {
                    System.out.println("No magic in my Dungeon!");
                    getDamage(10);
                }
            else
                break;
        }
        return answer;
    }

    public Boolean isAlive() {
        return this.health > 0;
    }

    public int getDamage(int damage) {
        health -= damage;
        System.out.println("(You get damage - " + damage + ")");
        return health;
    }

    public String getInfo() {
        return "\nPerson's information: " +
                "\nYour health " + health +
                "\nYour score: " + score;
    }
}
