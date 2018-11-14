import java.util.ArrayList;
import java.util.List;

interface Op {
    Event execute();
}


public class EventList {

    List<Op> events;

    EventList(Player player) {
        events = new ArrayList<>();
        events.add(() -> new EventTomb(player));
        events.add(() -> new EventBearFight(player));
        events.add(() -> new EventQuiz(player));
        events.add(() -> new EventCleric(player));
    }

    EventList(){
        events = new ArrayList<>();
    }

    public void remove(int index) {
        events.remove(index);
    }

    public Event getEvent(int index) {
        return events.get(index).execute();
    }

    public int count() {
        return events.size();
    }

}
