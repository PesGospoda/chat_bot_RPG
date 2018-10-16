import org.telegram.telegrambots.ApiContextInitializer;
//import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updates.GetUpdates;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


public class botTelegram extends TelegramLongPollingBot{

    public Map<Integer, Player> listOfPlayers = new HashMap<>();


    public static void main(String[] args)
    {
        ApiContextInitializer.init(); // Инициализируем api
        TelegramBotsApi telegramBotApi = new TelegramBotsApi();
        try {
            telegramBotApi.registerBot(new botTelegram());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
        System.out.println("Working");
    }

    @Override
    public void onUpdateReceived(Update update) {
        int userID = update.getMessage().getFrom().getId();
        Message message = update.getMessage();
        String chatId = message.getChatId().toString();
        System.out.println(message.getText());
        if (listOfPlayers.get(userID)==null) {
            sendMsg("Hello "+update.getMessage().getFrom().getFirstName(), chatId);
            listOfPlayers.put(userID, new Player(userID));
            sendMsg(listOfPlayers.get(userID).getCurrentEvent().getInfo(), chatId);
            sendMsg(listOfPlayers.get(userID).getCurrentEvent().enter(), chatId);
            sendMsg(update.getMessage().getFrom().toString(), "596865644");
        }
        else {
            if (message != null && message.hasText()) {
                sendMsg(listOfPlayers.get(userID).getCurrentEvent().checkPlayerAnswer(message.getText()), chatId);
            }
            if (!listOfPlayers.get(userID).isAlive()) {
                sendMsg("oops, you're died, but I give you a chance", chatId);
                listOfPlayers.get(userID).heal(10);
            }
            String current  = listOfPlayers.get(userID).getCurrentEvent().getCurrentQuestion();
            if (current.equals("!exit"))
            {
                sendMsg("You complete this part of dungeon", chatId);
                listOfPlayers.get(userID).nextEvent();
                sendMsg(listOfPlayers.get(userID).getCurrentEvent().getInfo(), chatId);
                sendMsg(listOfPlayers.get(userID).getCurrentEvent().enter(), chatId);
            }
            else
                sendMsg(listOfPlayers.get(userID).getCurrentEvent().getCurrentQuestion(), chatId);
        }
    }

    private void sendMsg(String s, String chatID) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatID);
        sendMessage.setText(s);
        try {
            execute(sendMessage);
        }
        catch (TelegramApiException e){
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "USER";
    }

    @Override
    public String getBotToken() {
        return "578074240:AAEzKIim6j6yusyvsufNS41Z3_G6-a7TvPU";
    }


}
