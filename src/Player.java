import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {


    public long getChatID() {
        return chatID;
    }

    private String name;
    private int score;
    private int health;
    public List<String> msgs;

    private int playerID;
    private long chatID;
    private int currentEventIndex;
    private EventList eventList;

    public Player(int playerID, long chatID, String name) {
        this.score = 0;
        this.name = name;
        this.health = 100;
        this.chatID = chatID;
        this.playerID = playerID;
        eventList = new EventList(this);
        this.currentEventIndex = new Random().nextInt(eventList.events.size());
        this.msgs = new ArrayList<>();
    }

    public void sendMsg(String text) {
        msgs.add(text);
        //getBot().sendMsg(text, getChatID());
    }

    public void getInfo() {
        sendMsg("\nPerson's information: " +
                "\nYour health " + health +
                "\nYour score: " + score);
    }

    public void newGame() {
        health = 100;
        // ?? score = 0;
        eventList = new EventList(this);
    }

    public void nextEvent() // это можна в лист евентов пихнуть
    {
        if (eventList.getEvent(currentEventIndex).checkDispose())
            eventList.remove(currentEventIndex);
        if (eventList.count() == 0) {
            eventList.events.add(new NewGame(this));
            currentEventIndex = 0;
        } else {
            currentEventIndex = new Random().nextInt(eventList.events.size());
        }
        getCurrentEvent().start();

    }

    public int getHealth() {
        return health;
    }

    public List<String> getMsgs() {
        return msgs;
    }

    public int getCurrentEventIndex() {
        return currentEventIndex;
    }

    public EventList getEventList() {
        return eventList;
    }

    public int getPlayerID() {
        return playerID;
    }

    public Event getCurrentEvent() {
        return this.eventList.events.get(currentEventIndex);
    }

    public Boolean isAlive() {
        return this.health > 0;
    }

    public void getDamage(int damage) {
        health -= damage;
        sendMsg("(You getEvent damage - " + damage + ")");
    }

    public void heal(int healPoints) {
        health += healPoints;
        sendMsg("(You getEvent heal - " + healPoints + ")");
    }


}
