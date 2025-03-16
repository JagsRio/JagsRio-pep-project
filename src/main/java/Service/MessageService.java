package Service;
import java.util.*;
import Model.Message;

public interface MessageService {
    public abstract void createMessage(Message msg);
    public abstract List<Message> getAllMessages();
    public abstract Message getMessageById(int msgId);
    public abstract void deleteMessage(int msgId);
    public abstract void updateMessage(int msgId, Message newMsg);
    public abstract List<Message> getAllMessagesByAccountId(int accountId);
}
