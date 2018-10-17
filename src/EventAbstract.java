import java.util.List;

public abstract class EventAbstract {
    public abstract String getInfo() ;
    public abstract String checkPlayerAnswer(String answer);
    public abstract String enter();
    public abstract String nextQuestion();

    private final boolean isDisposable;
    protected Player player;
    protected int questionCounter;

    public EventAbstract(Player p, Boolean disposable){
        isDisposable = disposable;
        player = p;
        questionCounter = 0;
    }

    public boolean checkDispose(){
        return isDisposable;
    }
}

