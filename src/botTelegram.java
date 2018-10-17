//import org.telegram.telegrambots.api.objects.Update;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.Map;


public class botTelegram extends TelegramLongPollingBot {

    public Map<Integer, Player> listOfPlayers = new HashMap<>();
    private String BOT_NAME;
    private String BOT_TOKEN;

    public botTelegram(String botToken, String botUsername) {
        //super();
        BOT_NAME = botUsername;
        BOT_TOKEN = botToken;
    }

    private void newPlayer(int userID, String chatId, String name) {
        sendMsg("Hello " + name, chatId);
        listOfPlayers.put(userID, new Player(userID, name));//core mb
        sendMsg(listOfPlayers.get(userID).getCurrentEvent().getInfo(), chatId);
        sendMsg(listOfPlayers.get(userID).getCurrentEvent().enter(), chatId);
    }

    private void nextEvent(int userID, String chatId){
        listOfPlayers.get(userID).nextEvent();
        sendMsg(listOfPlayers.get(userID).getCurrentEvent().getInfo(), chatId);
        sendMsg(listOfPlayers.get(userID).getCurrentEvent().enter(), chatId);
    }

    @Override
    public void onUpdateReceived(Update update) {
        int userID = update.getMessage().getFrom().getId();
        Player player = listOfPlayers.get(userID);
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();
        if (player == null) {
            newPlayer(userID, chatId, update.getMessage().getFrom().getFirstName());
            player = listOfPlayers.get(userID);
        } else {
            if (message.hasText()) {
                sendMsg(player.getCurrentEvent().checkPlayerAnswer(message.getText().toLowerCase()), chatId);
            }
            if (!player.isAlive()) {
                sendMsg("oops, you're died, but I give you a chance", chatId);
                player.heal(10);
                // _-_ hz mb
            }
            if (player.getCurrentEvent().nextQuestion() == null) {
                sendMsg("You complete this part of dungeon", chatId);
                nextEvent(userID,chatId);
            } else
                sendMsg(player.getCurrentEvent().nextQuestion(), chatId);
        }
    }

    private void sendMsg(String s, String chatID) {
        try {
            execute(new SendMessage().setChatId(chatID).setText(s));
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
