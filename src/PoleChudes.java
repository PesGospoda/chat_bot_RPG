
public class PoleChudes extends EventAbstract {
	
	private String eventName = "PoleChudes";

    private String quizWord;

    private StringBuilder answerWord = new StringBuilder();

	private Player player;

    public String getEventName()
	{
		return eventName;
	}

    public PoleChudes(String quizWord) {
        this.quizWord = quizWord;
        for (int i=0; i<quizWord.length(); i++)
            answerWord.append(".");
    }

    private void setLetter(char letter) {
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

	public void execute(Player player)
	{
	    this.player = player;
        System.out.println("Welcome on The Game");
        while(player.isAlive() && !quizWord.equals(answerWord.toString()))
        {
            System.out.println(answerWord);
            System.out.println("say letter");
            String inputLower = player.getAnswer().toLowerCase();
            if (inputLower.equals("!exit"))
                break;
            if (inputLower.length()!=1)
                System.out.println("this is not a letter");
            else
                setLetter(inputLower.charAt(0));
        }

	}
}

