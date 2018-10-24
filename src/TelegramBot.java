//import org.telegram.telegrambots.api.objects.Update;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TelegramBot extends TelegramLongPollingBot {

    public Map<Integer, Player> listOfPlayers = new HashMap<>();
    private String BOT_NAME;
    private String BOT_TOKEN;
//tg://proxy?server=136.0.99.154&port=3256&secret=0123456789abcdef0123456789abcdef
    //public static DefaultBotOptions create(){
    //    var opt = new DefaultBotOptions();
//
    //    var http = new HttpHost("142.93.97.13", 3256);
    //    opt.setRequestConfig(RequestConfig.custom().setAuthenticationEnabled(false).setProxy(http).build());
     //   return opt;
    //}

    public TelegramBot(String botToken, String botUsername) {

        super();
        BOT_NAME = botUsername;
        BOT_TOKEN = botToken;

    }

    private void newPlayer(int userID, long chatId, String name) {
        sendMsg("Hello " + name, chatId);
        listOfPlayers.put(userID, new Player(userID, chatId, name));//core mb
        listOfPlayers.get(userID).getCurrentEvent().start();
        sendListMsg(listOfPlayers.get(userID));
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
            if (!player.isAlive()) {
                //sendFoto("https://www.geekalerts.com/u/Dark-Souls-You-Died-Tee1-e1471365276776.jpg", player.getChatID());
                listOfPlayers.remove(userID);
            } else if (message.hasText()) {
                player.getCurrentEvent().checkPlayerAnswer(message.getText().toLowerCase());
            }

            sendListMsg(player);
        }
    }

    public void sendListMsg(Player player) {
        for (String i :
                player.msgs) {
            sendMsg(i, player.getChatID());
        }
        player.msgs = new ArrayList<>();
    }

    //public void sendFoto(String foto, long chatId) {
    //    try {
    //        execute(new SendPhoto().setPhoto(foto).setChatId(chatId));
    //    } catch (TelegramApiException e) {
    //        e.printStackTrace();
    //    }
    //}

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
