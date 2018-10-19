
public abstract class Event {
    public abstract void getInfo(); // сведения об эвенте

    //public abstract void checkPlayerAnswer(String answer);
    public abstract void start();// старт события

    public abstract void nextQuestion();// переход состояний

    public abstract void end(); // что будет происходить в конце эвента

    private TechnicalCommands techCommands;

    private final boolean isDisposable;
    protected Player player;

    public void checkPlayerAnswer(String key) {
        if (techCommands.contains(key)) {
            techCommands.doOperation(key);
        }
    }

    public Event(Player p, Boolean disposable) {
        isDisposable = disposable;
        player = p;
        techCommands = new TechnicalCommands(player);
    }

    public TelegramBot getBot() {
        return player.getBot();
    }


    public boolean checkDispose() {
        return isDisposable;
    }
}

