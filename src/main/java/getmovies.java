


import com.vdurmont.emoji.EmojiParser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class getmovies  extends TelegramLongPollingBot
{

        public String getBotUsername()
        {
            return "KMovies_bot";
        }
    @Override
    public String getBotToken() 
    {
        return "1140361961:AAHfEZNvQA56j2hQmLvOuDhmV9FK0Ul5AE8";
    }
    
    @Override
    public void onUpdateReceived(Update update) {
                String message = update.getMessage().getText();
               String user_first_name = update.getMessage().getChat().getUserName();      
                System.out.println(message+""+user_first_name);
            try {
                    try {
                        sendMsg(update.getMessage().getChatId().toString(), message,user_first_name);
                    } catch (TelegramApiException ex) {
                        Logger.getLogger(getmovies.class.getName()).log(Level.SEVERE, null, ex);
                    }
               
            } catch (IOException ex) {
                Logger.getLogger(getmovies.class.getName()).log(Level.SEVERE, null, ex);
            }
            }        
    public synchronized void sendMsg(String chatId, String s,String username) throws IOException, TelegramApiException 
    {
                Message message = null;    
                SendMessage sendMessage = new SendMessage();
                               sendMessage.enableMarkdown(true);
                sendMessage.setChatId(chatId);                      
                movieslist obj=new movieslist();                 
                sendMessage.setText(obj.movies());
                sendMessage(sendMessage);
    }
    
}
