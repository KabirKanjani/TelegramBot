
import com.vdurmont.emoji.EmojiParser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


public class TelgramBot  extends TelegramLongPollingBot
{

        public String getBotUsername()
        {
            return "PrimeMinister_bot";
        }
    @Override
    public String getBotToken() 
    {
        return "1030228608:AAHQgLaX9LTYQm9A1SArBcZKdDA3h9h8v7E";
    }
    
    @Override
    public void onUpdateReceived(Update update) {
                String message = update.getMessage().getText();
               String user_first_name = update.getMessage().getChat().getUserName();       
            try {
                sendMsg(update.getMessage().getChatId().toString(), message,user_first_name);
            } catch (IOException ex) {
                Logger.getLogger(TelgramBot.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
public synchronized void sendMsg(String chatId, String s,String username) throws IOException {
    Message message = null;    
    SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);                      
        CapitalConnect obj=new CapitalConnect();
        System.out.println(sendMessage.getChatId()+""+s);        
        String emo=EmojiParser.parseToUnicode(":smiley:");
        
        if(s .equalsIgnoreCase("UK")||s.equalsIgnoreCase("UNITED KINGDOM"))
        {    
            sendMessage.setText("London");
        }
        if(s.equalsIgnoreCase("hello")||s.equalsIgnoreCase("hy")||s.equalsIgnoreCase("hi")||s.equalsIgnoreCase("hey"))       
        {
            sendMessage.setText("Yo! Uninformed fucks,\n" +
"I know you losers have shitty brain\n" +
"memory, so here to make your worthless" +
"life a little better, If your lil\n" +
"brain at all try typing up a country's\n" +
"name if your mom taught you how to\n" +
"spell and even if she did, Chill, you\n" +
"are still a loser who doesn't know\n" +
"countries and capitals...\n" +
"\n" +
"Try typing up a country's name FAGGOT..");
        }               
        else if(s.equalsIgnoreCase("US")||s.equalsIgnoreCase("America")||s.equalsIgnoreCase("USA"))
        {
            sendMessage.setText("Washington D.C");
        }
        else
        {
            sendMessage.setText(obj.getcapital(s));
        }       
        try
        {
            sendMessage(sendMessage);
        } 
        catch (TelegramApiException e) 
        {
            System.out.println("Error Loading");
        }
    }
    
}
