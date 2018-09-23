public class Core {
    public Player player = new Player();
    private Parser text;
    private Bot bot;

    public Core(String text) {
        this.text = new Parser(text);
        this.bot = new Bot(this.text.GetDictionary());
    }
}
