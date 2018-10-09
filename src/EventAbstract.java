

public abstract class EventAbstract {
    public abstract void execute();

    public EventAbstract(Player player) {
        this.player = player;
    }

    protected Player player;

    public abstract String getInfo() ;
}

