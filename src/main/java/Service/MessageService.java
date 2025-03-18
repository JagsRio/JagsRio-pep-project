package Service;
import java.util.*;
import Model.Message;

public interface MessageService {
    public abstract Message createMessage(String message_text, int posted_by, long timeposted);
    public abstract List<Message> getAllMessages();
    public abstract Message getMessageById(int msgId);
    public abstract Message deleteMessage(int msgId);
    public abstract Message updateMessage(int msgId, String message_text);
    public abstract List<Message> getAllMessagesByAccountId(int accountId);
}
