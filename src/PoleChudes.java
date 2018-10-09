
public class PoleChudes extends EventAbstract {

    private String quizWord;

    public String getAnswerWord() {
        return answerWord.toString();
    }

    private StringBuilder answerWord = new StringBuilder();

    public PoleChudes(Player player, String quizWord) {
        super(player);
        this.quizWord = quizWord;
        for (int i = 0; i < quizWord.length(); i++)
            answerWord.append(".");
    }

    public String getInfo() {
        return "\nYou are on the Wheel of Fortune television show!\n" +
                "Name the letter that you think is in the proposed word and guess the word";
    }

    public void setLetter(char letter) {
        if (quizWord.contains(letter + "")) {
            System.out.println("good");
            for (int i = 0; i < quizWord.length(); i++)
                if (quizWord.charAt(i) == letter)
                    answerWord.setCharAt(i, letter);
        } else {
            System.out.println("there is no such letter");
            player.getDamage(10);
        }
    }

    public void execute() {
        player.setCurrentEvent(this);
        System.out.println("Welcome on The Game");
        while (player.isAlive() && !quizWord.equals(answerWord.toString())) {
            System.out.println(answerWord);
            System.out.println("say letter");
            String inputLower = player.getAnswer().toLowerCase();
            if (inputLower.equals("!exit"))
                break;
            if (inputLower.length() != 1)
                System.out.println("this is not a letter");
            else
                setLetter(inputLower.charAt(0));
        }

    }
}

