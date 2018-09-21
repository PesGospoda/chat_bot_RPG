import java.util.Scanner;

public class Player {
    public int getScore() {
        return score;
    }

    private void setScore(int score) {
        this.score = score;
    }
    private int score;

    private final Scanner input = new Scanner(System.in);

    public  String getAnswer() {
        return input.nextLine();
    }
}
