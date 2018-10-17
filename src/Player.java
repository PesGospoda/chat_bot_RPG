import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player {

    public Player(int playerID, String name) {
        this.score = 0;
        this.name = name;
        this.health = 100;
        this.playerID = playerID;
        eventList = new EventList(this);
        this.CurrentEventIndex = 0;
    }
    public Player() {

    }
    private String name;
    private int score;
    private int health;
    private int playerID;
    private int CurrentEventIndex;
    private TechnicalCommands techCommands = new TechnicalCommands(this);
    private EventList eventList;
    private botTelegram bot;


    public void nextEvent()
    {
        if (eventList.events.get(CurrentEventIndex).checkDispose())
            eventList.events.remove(CurrentEventIndex);
        Random rnd = new Random();
        int next = rnd.nextInt(eventList.events.size());
        CurrentEventIndex = next;

    }

    public EventAbstract getCurrentEvent() {
        return this.eventList.events.get(CurrentEventIndex);
    }

    public Boolean isAlive() {
        return this.health > 0;
    }

    public String getDamage(int damage) {
        health -= damage;
        return "(You get damage - " + damage + ")";
    }

    public String heal(int healPoints) {
        health += healPoints;
        return "(You get heal - " + healPoints + ")";
    }

    public String getInfo() {
        return "\nPerson's information: " +
                "\nYour health " + health +
                "\nYour score: " + score;
    }
}
