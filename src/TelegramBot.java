//import org.telegram.telegrambots.api.objects.Update;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TelegramBot extends TelegramLongPollingBot {

    public Map<Integer, Player> listOfPlayersInDungeon = new HashMap<>();
    private String BOT_NAME;
    private String BOT_TOKEN;
    //SQL stuff
    private static final String url = "jdbc:mysql://localhost:3306/chat_bot_users?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "1234";
    private static Connection con;

    //commands
    private static String selectPlayerString = "SELECT * FROM players WHERE userID=?";
    private static String updateString = "UPDATE players SET experience=?, hp=? WHERE userID=?";
    private static String insertNewPlayerString =  "INSERT INTO players VALUES (?, ?, ?, ?)";
    private static PreparedStatement selectPlayerCommand;
    private static PreparedStatement updateCommand;
    private static PreparedStatement insertNewPlayerCommand;


    public TelegramBot(String botToken, String botUsername) {

        super();
        BOT_NAME = botUsername;
        BOT_TOKEN = botToken;
        try{
            con = DriverManager.getConnection(url, user, password);
            selectPlayerCommand = con.prepareStatement(selectPlayerString);
            updateCommand = con.prepareStatement(updateString);
            insertNewPlayerCommand = con.prepareStatement(insertNewPlayerString);
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }


    }

    private void newPlayer(int userID, long chatId, String name) {
        sendMsg("Hello " + name, chatId);
        listOfPlayersInDungeon.put(userID, new Player(userID, chatId, name));//core mb
        listOfPlayersInDungeon.get(userID).getCurrentEvent().start();
        sendListMsg(listOfPlayersInDungeon.get(userID));
    }

    private void newPlayer(int userID, long chatId, String name, int experience, int health) {
        sendMsg("Hello " + name, chatId);
        listOfPlayersInDungeon.put(userID, new Player(userID, chatId, name, experience, health));//core mb
        listOfPlayersInDungeon.get(userID).getCurrentEvent().start();
        sendListMsg(listOfPlayersInDungeon.get(userID));
    }

    private void insertPlayerToDB(int userID, long chatId, String name) {
        try {
            insertNewPlayerCommand.setInt(1, userID);// playerID
            insertNewPlayerCommand.setString(2, name);//player name
            insertNewPlayerCommand.setInt(3, 0);//experience
            insertNewPlayerCommand.setInt(4, 100);//health
            insertNewPlayerCommand.executeUpdate();
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        int userID = update.getMessage().getFrom().getId();
        Message message = update.getMessage();
        long chatId = message.getChatId();
        try {
            selectPlayerCommand.setInt(1, userID);
            ResultSet playerData = selectPlayerCommand.executeQuery();
            if (!playerData.next()) {
                insertPlayerToDB(userID, chatId, update.getMessage().getFrom().getFirstName());
                newPlayer(userID, chatId, update.getMessage().getFrom().getFirstName());
            }
            else {
                if (listOfPlayersInDungeon.get(userID)==null) {
                    selectPlayerCommand.setInt(1, userID);
                    ResultSet rs = selectPlayerCommand.executeQuery();
                    rs.next();
                    newPlayer(userID,
                            chatId,
                            update.getMessage().getFrom().getFirstName(),
                            rs.getInt("experience"),
                            rs.getInt("hp"));
                }
                Player player = listOfPlayersInDungeon.get(userID);
                if (message.hasText()) {
                    player.getCurrentEvent().checkPlayerAnswer(message.getText().toLowerCase());
                    sendListMsg(player);
                }
            }
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public void sendListMsg(Player player) {
        for (String i :
                player.msgs) {
            if (i.equals("!finish")) {
                updatePlayer(player);
            }
            sendMsg(i, player.getChatID());
        }
        player.msgs = new ArrayList<>();
    }

    public void updatePlayer(Player player){
        try {
            updateCommand.setInt(1, player.getExperience());
            updateCommand.setInt(2, player.getHealth());
            updateCommand.setInt(3, player.getPlayerID());
            updateCommand.executeUpdate();
        }
        catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
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
