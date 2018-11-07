//import org.telegram.telegrambots.api.objects.Update;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TelegramBot extends TelegramLongPollingBot {

    public Map<Integer, Player> listOfPlayersInDungeon = new HashMap<>();
    private String BOT_NAME;
    private String BOT_TOKEN;

    private static final String url = "jdbc:mysql://localhost:3306/chat_bot_users?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "1234";

    private MySQL dataBase;


    public TelegramBot(String botToken, String botUsername) {

        super();
        BOT_NAME = botUsername;
        BOT_TOKEN = botToken;
        dataBase = new MySQL(url, user, password);
    }

    private void newPlayer(int userID, long chatId, String name) {
        Player newPlayer = new Player(userID, chatId, name);
        listOfPlayersInDungeon.put(userID, newPlayer);
        dataBase.loadInfo(newPlayer);
        newPlayer.sendMsg("Hello " + name);
        newPlayer.getCurrentEvent().start();
    }

    @Override
    public void onUpdateReceived(Update update) {
        int userID = update.getMessage().getFrom().getId();
        Message message = update.getMessage();
        long chatId = message.getChatId();
        Player player = listOfPlayersInDungeon.get(userID);
        if (player == null) {
            newPlayer(userID, chatId, update.getMessage().getFrom().getFirstName());
            player = listOfPlayersInDungeon.get(userID);
        }

        if (message.hasText()) {
            player.getCurrentEvent().checkPlayerAnswer(message.getText().toLowerCase());
            sendListMsg(player);
        }
        if (!player.isAlive())
            dataBase.updatePlayer(player);
    }

    public void sendListMsg(Player player) {
        for (String i :
                player.msgs) {
            sendMsg(i, player.getChatID());
        }
        player.msgs = new ArrayList<>();
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
