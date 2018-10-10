
import java.util.Random;

public class Core {

    public static void start(Player player) {
        System.out.println("You're entering the dungeon...");
        System.out.println("If you're a dumb loser ask help... \n(!help) ");
        EventList eventsList = new EventList(player);
        Random rnd = new Random();
        while (eventsList.Count() != 0 && player.isAlive()) {
            int nextEvent = rnd.nextInt(eventsList.Count());
            System.out.println(eventsList.events.get(nextEvent).getInfo());
            eventsList.events.get(nextEvent).execute();
            eventsList.remove(nextEvent);
            System.out.println("End of event");

        }
        if (player.isAlive())
            System.out.println("Dungeon completed!");
        else
            System.out.println("You dead.");
    }
}