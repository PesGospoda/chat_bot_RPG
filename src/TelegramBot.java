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
        dataBase.loadInfo(newPlayer);
        listOfPlayersInDungeon.put(userID, newPlayer);
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
    }

    public void sendListMsg(Player player) {
        String inputStr = "";
        sendMsgCycle:
        for (String i :
                player.msgs) {
            inputStr = i;
            switch (inputStr) {
                case "!dead":
                    player.dead();
                    dataBase.loadInfo(player);
                    break sendMsgCycle;
                case "!finish":
                    dataBase.updatePlayer(player);
                    break;
                default:
                    sendMsg(inputStr, player.getChatID());
                    break;
            }
        }
        player.msgs.clear();
        if (inputStr.equals("!dead")) {
            player.nextEvent();// здесь мы отправляем то что менюха выдала
            sendListMsg(player);
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
