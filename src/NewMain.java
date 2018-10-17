import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class NewMain {

    private static String BOT_NAME = "USER";
    private static String BOT_TOKEN = "578074240:AAEzKIim6j6yusyvsufNS41Z3_G6-a7TvPU" /* your bot's token here */;

    public static void main(String[] args) {
        botTelegram bot;
        try {
            ApiContextInitializer.init(); // init api
            bot = new botTelegram(BOT_TOKEN, BOT_NAME);
            TelegramBotsApi telegramBotApi = new TelegramBotsApi();
            telegramBotApi.registerBot(bot);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        System.out.println("Working");
    }

    private static void useVidalia() {
        System.getProperties().put("proxySet", "true");
        System.getProperties().put("socksProxyHost", "127.0.0.1");
        System.getProperties().put("socksProxyPort", "9150");
    }
}
