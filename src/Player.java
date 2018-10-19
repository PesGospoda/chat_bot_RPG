import java.util.Random;

public class Player {

    public TelegramBot getBot() {
        return bot;
    }

    public long getChatID() {
        return chatID;
    }

    public Player(int playerID, long chatID, String name, TelegramBot bot) {
        this.score = 0;
        this.name = name;
        this.health = 100;
        this.chatID = chatID;
        this.bot = bot;
        this.playerID = playerID;
        this.currentEventIndex = 0;
        eventList = new EventList(this);
        //test sendMsg("```######\n#######\n####   ##\n########```");
    }

    public Player() {

    }

    private String name;
    private int score;
    private int health;

    public int getPlayerID() {
        return playerID;
    }

    private int playerID;
    private long chatID;
    private int currentEventIndex;
    private EventList eventList;
    private TelegramBot bot;


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

    public void sendMsg(String text) {
        getBot().sendMsg(text, getChatID());
    }

    public void getInfo() {
        sendMsg("\nPerson's information: " +
                "\nYour health " + health +
                "\nYour score: " + score);
    }

    public void newGame() {
        health = 100;
        // ?? score = 0;
        eventList = new EventList(this);//wtf почему конструктор не подрубается и без эвентов создается???
        // если не сможешь исправить запили в евентлисте метод который будет сразу все добавлять
        eventList.events.add(new EventTomb(this));
    }
}
