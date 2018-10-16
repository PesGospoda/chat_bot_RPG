import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

    public Player(int playerID) {
        this.score = 0;
        this.health = 100;
        this.playerID = playerID;
        setCurrentEvent(this.eventList.events.get(0));
        this.CurrentEventIndex = 0;
    }

    private int score;
    private int health;
    private int playerID;
    private EventAbstract currentEvent;
    private int CurrentEventIndex;
    private TechnicalCommands techCommands = new TechnicalCommands(this);
    private EventList eventList = new EventList(this);

    public void setCurrentEvent(EventAbstract currentEvent)
    {
        this.currentEvent = currentEvent;
    }

    public void nextEvent()
    {
        if (currentEvent.checkDispose())
            eventList.events.remove(CurrentEventIndex);
        Random rnd = new Random();
        int next = rnd.nextInt(eventList.events.size());
        CurrentEventIndex = next;
        setCurrentEvent(eventList.events.get(next));
    }

    public EventAbstract getCurrentEvent() {
        return this.currentEvent;
    }

    public Boolean isAlive() {
        return this.health > 0;
    }

    public int getDamage(int damage) {
        health -= damage;
        System.out.println("(You get damage - " + damage + ")");
        return health;
    }

    public int heal(int healPoints) {
        health += healPoints;
        System.out.println("(You get heal - " + healPoints + ")");
        return health;
    }

    public String getInfo() {
        return "\nPerson's information: " +
                "\nYour health " + health +
                "\nYour score: " + score;
    }
}
