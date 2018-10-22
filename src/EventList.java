import java.util.ArrayList;
import java.util.List;

public class EventList {

    List<Event> events;

    EventList(Player player) {
        events = new ArrayList<>();
        events.add(new EventTomb(player));
        events.add(new EventBearFight(player));
        events.add(new EventQuiz(player));
    }

    public void remove(int index) {
        events.remove(index);
    }

    public Event getEvent(int index) {
        return events.get(index);
    }

    public int count() {
        return events.size();
    }

}
