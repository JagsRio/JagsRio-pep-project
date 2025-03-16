package Service;

import java.util.ArrayList;
import java.util.List;

import Model.Message;

public class MessageServiceImpl implements MessageService {

    @Override
    public void createMessage(Message msg) {
    }

    @Override
    public List<Message> getAllMessages() {
        List<Message> allMessages = new ArrayList<>();
        return allMessages;
    }

    @Override
    public Message getMessageById(int msgId) {
        Message msg = null;
        return msg;
    }

    @Override
    public void deleteMessage(int msgId) {
    }

    @Override
    public void updateMessage(int msgId, Message newMsg) {
    }

    @Override
    public List<Message> getAllMessagesByAccountId(int accountId) {
        List<Message> allMessages = new ArrayList<>();
        return allMessages;
    }


    
}
