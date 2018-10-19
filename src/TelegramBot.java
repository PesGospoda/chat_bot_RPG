//import org.telegram.telegrambots.api.objects.Update;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;


public class TelegramBot extends TelegramLongPollingBot {

    public Map<Integer, Player> listOfPlayers = new HashMap<>();
    private String BOT_NAME;
    private String BOT_TOKEN;

    public TelegramBot(String botToken, String botUsername) {
        super();
        BOT_NAME = botUsername;
        BOT_TOKEN = botToken;
    }

    private void newPlayer(int userID, long chatId, String name) {
        sendMsg("Hello " + name, chatId);
        listOfPlayers.put(userID, new Player(userID, chatId, name, this));//core mb
        listOfPlayers.get(userID).getCurrentEvent().start();
    }

    @Override
    public void onUpdateReceived(Update update) {
        int userID = update.getMessage().getFrom().getId();
        Player player = listOfPlayers.get(userID);
        Message message = update.getMessage();
        long chatId = message.getChatId();
        if (player == null) {
            newPlayer(userID, chatId, update.getMessage().getFrom().getFirstName());
        } else {
            if (message.hasText()) {
                player.getCurrentEvent().checkPlayerAnswer(message.getText().toLowerCase());
            }
            if (!player.isAlive()) {
                sendMsg("oops, you're died, but I give you a chance", chatId);//!!
                player.heal(10);
            }
        }
    }

    public void sendMsg(String s, long chatID) {
        try {
            execute(new SendMessage().setChatId(chatID).setText(s).enableMarkdown(true));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }


}
