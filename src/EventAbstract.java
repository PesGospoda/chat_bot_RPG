import java.util.List;

public abstract class EventAbstract {
    public abstract String getInfo() ;
    public abstract String checkPlayerAnswer(String answer);
    public abstract String enter();
    public abstract String getCurrentQuestion();
    public abstract boolean checkDispose();
}

