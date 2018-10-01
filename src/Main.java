import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("You're entering the dungeon...");
        Player player = new Player();
        var game = new Core();
        game.start(player);
    }
}
