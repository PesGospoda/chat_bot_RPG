public class Core extends eventAbstract{    public Player player = new Player();    private Parser text = new Parser("diologs.txt");    private Bot bot;    private String eventName = "Core";        public String GetEventName()    {    	return eventName;    }    public Core() {        //this.text = new Parser(text);        this.bot = new Bot(this.text.toListQuestions());    }    public void Execute(Player player){        while (this.player.IsAlive() && this.bot.NotEnd()){            System.out.println(bot.NextQuestion());            if (bot.IsTrueAnswer(player.getAnswer()))                System.out.println("�����"); //тут надо боту добавить список реплик на верный ответ ну и не наверный на первое время потом сюжетку пилить будем            else{                System.out.println("�������!");                player.getDamage(10);            }        }    }}