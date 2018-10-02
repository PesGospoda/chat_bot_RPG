
public class PoleChudes extends EventAbstract {
	
	public String eventName = "PoleChudes";

	public Player player = new Player();

    public String getEventName()
	{
		return eventName;
	}

    public String quizWord;

    public StringBuilder answerWord = new StringBuilder();

    public PoleChudes(String quizWord) {
        this.quizWord = quizWord;
        for (int i=0; i<quizWord.length(); i++)
            answerWord.append(".");
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

	public void execute(Player player)
	{
	    this.player = player; //выпилить в конструктор
        System.out.println("Welcome on The Game");
        while(player.isAlive() && !quizWord.equals(answerWord.toString()))
        {
            System.out.println(answerWord);
            System.out.println("say letter");
            String inputLower = player.getAnswer().toLowerCase();
            if (inputLower.length()!=1)
                System.out.println("this is not a letter");
            else
                setLetter(inputLower.charAt(0));
        }

	}
}

