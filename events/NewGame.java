public class NewGame extends Event {//хз нужно ли это новая игра теперь другая но вдруг что отсюда понадобится
    public NewGame(Player player) {
        super(player, false);
    }

    @Override
    public void getInfo() {
        player.sendMsg("New game? ```(yes/no)```");
    }

    @Override
    public void checkPlayerAnswer(String answer) {
        if (answer.equals("yes")) {
            //player.newGame();
            end();
        } else
            player.sendMsg("Then go out!");
    }

    @Override
    public void start() {
        getInfo();
    }

    @Override
    public void nextQuestion() {

    }

    @Override
    public void end() {
        player.nextEvent();
    }
}
