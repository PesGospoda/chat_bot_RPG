import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {


    public long getChatID() {
        return chatID;
    }

    public String getName() {
        return name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private String name;
    private int score;
    private int experience;
    private int health;
    public List<String> msgs;

    private int playerID;
    private long chatID;
    private int currentEventIndex;
    private EventList eventList;
    private List<Event> dungeonEventList;
    private Random rnd = new Random();

    public Player(int playerID, long chatID, String name) {
        this.experience = 0;
        this.name = name;
        this.health = 100;
        this.chatID = chatID;
        this.playerID = playerID;
        eventList = new EventList(this);
        this.msgs = new ArrayList<>();
        this.dungeonEventList = new ArrayList<>();
        dungeonEventList.add(new EventMenu(this));
        this.currentEventIndex = 0;
    }

    public void sendMsg(String text) {
        msgs.add(text);
    }

    public void getInfo() {
        sendMsg("\nPerson's information: " +
                "\nYour health " + health +
                "\nYour score: " + score);
    }


    public void nextEvent()
    {
        if (currentEventIndex + 1 >= dungeonEventList.size()) {
            dungeonEventList.clear();
            dungeonEventList.add(new EventMenu(this));
            currentEventIndex = 0;
            sendMsg("!finish");
        } else
            currentEventIndex += 1;
        getCurrentEvent().start();

    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
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
        return this.dungeonEventList.get(currentEventIndex);
    }

    public Boolean isAlive() {
        if (health > 0)
            return true;
        return false;
    }

    public void getDamage(int damage) {
        health -= damage;
        sendMsg("(You got damage - " + damage + ")");
        if (!isAlive())
            dead();
    }

    public void dead() {
        sendMsg("you died, returning to main menu");
        sendMsg("!dead");
        //heal(100);
        currentEventIndex = dungeonEventList.size();//здесь мы просто уходим в конец списка ивентов
        //nextEvent(); //это перенесено в бота знаю что костыль но потом подумаю как лучше
    }

    public void heal(int healPoints) {
        health += healPoints;
        sendMsg("(You got heal - " + healPoints + ")");
    }

    public void upExperience(int exp) {
        experience += exp;
        sendMsg("(You got experience + " + exp + ")");
    }

    public void makeEasyDungeon() {
        int numberOfEvents = rnd.nextInt(3) + 1;
        dungeonEventList.clear();
        for (int i = 0; i < numberOfEvents; i++) {
            int nextIndex = rnd.nextInt(eventList.events.size());
            dungeonEventList.add(eventList.events.get(nextIndex).execute());
            sendMsg(dungeonEventList.get(i).toString());
        }
        currentEventIndex = -1;
        nextEvent();
    }


}
