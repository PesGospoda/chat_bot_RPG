public class Сore {
    public Player player = new Player();
    private Parser text;
    private Bot bot;

    public Сore(String text) {
        this.text = new Parser(text);
        this.bot = new Bot(this.text.GetDictionary());
    }
}
