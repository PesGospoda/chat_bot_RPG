import java.util.ArrayList;
import java.util.List;

public class EventList {

    List<EventAbstract> events = new ArrayList<>();

    EventList(Player player) {
        events.add(new EventTomb(player));
       // events.add(new EventBearFight(player));
       // events.add(new EventQuiz());
    }

    public void Remove(int index) {
        events.remove(index);
    }

    public int Count() {
        return events.size();
    }

}
