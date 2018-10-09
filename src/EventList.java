import java.util.ArrayList;
import java.util.List;

public class EventList {

    List<EventAbstract> events = new ArrayList<>();

    EventList(Player player) {
        events.add(new Tomb(player));
        events.add(new PoleChudes(player, "hello"));
    }

    public void Remove(int index) {
        events.remove(index);
    }

    public int Count() {
        return events.size();
    }

}
