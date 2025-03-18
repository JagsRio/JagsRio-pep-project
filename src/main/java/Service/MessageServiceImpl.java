package Service;

import java.util.ArrayList;
import java.util.List;

import DAO.MessageDAO;
import DAO.MessageDAOImpl;
import Model.Message;

public class MessageServiceImpl implements MessageService {

    private MessageDAO messageDAO = new MessageDAOImpl();

    @Override
    public Message createMessage(String message_text, int posted_by, long timeposted) {
        Message newMessage = new Message();
        if ((message_text.length()==0) || (message_text.length()>244)){
            newMessage=null;
            return newMessage;
        }
        newMessage = messageDAO.createMessage(message_text, posted_by, timeposted);
        return newMessage;
    }

    @Override
    public List<Message> getAllMessages() {
        List<Message> allMessages = new ArrayList<>();
        allMessages = messageDAO.getAllMessages();
        return allMessages;
    }

    @Override
    public Message getMessageById(int msgId) {
        Message msg = new Message();
        if (msgId>0){
            msg = messageDAO.getMessageById(msgId);
        }
        else {
            msg=null;
        }
        return msg;
    }

    @Override
    public Message deleteMessage(int msgId) {
        Message msg = new Message();
        if (msgId > 0){
            msg = messageDAO.deleteMessage(msgId);
        } else {
            msg = null;
        }
        return msg;
    }

    @Override
    public Message updateMessage(int msgId, String message_text) {
        Message msg = new Message();
        if ((message_text.length()==0) || (message_text.length()>244)){
            msg=null;
            return msg;
        }
        if (msgId > 0){
            msg = messageDAO.updateMessage(msgId, message_text);
        } else {
            msg = null;
        }
        return msg;
    }

    @Override
    public List<Message> getAllMessagesByAccountId(int accountId) {
        List<Message> allMessages = new ArrayList<>();
        allMessages = messageDAO.getAllMessagesByAccountId(accountId);
        return allMessages;
    }


    
}
