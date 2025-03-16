package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Message;
import Util.ConnectionUtil;

public class MessageDAOImpl implements MessageDAO {
    public Message createMessage(String message_text, int posted_by, long timeposted){
        Message msg = new Message();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String createSql = "Insert into Message (posted_by, message_text, time_posted_epoch) values (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(createSql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, posted_by);
            ps.setString(2, message_text);
            ps.setLong(3, timeposted);
            int addedMsg = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int createMessageId = -1;

            if (addedMsg==1){
                while (rs.next()){
                    createMessageId = rs.getInt("message_id");
                }
                msg.setMessage_id(createMessageId);
                msg.setMessage_text(message_text);
                msg.setPosted_by(posted_by);
                msg.setTime_posted_epoch(timeposted);
                return msg;

            } else {
                msg =null;
                return msg;
            }
        } catch (SQLException e) {
            msg = null;
        }
        return msg;
    }
    
    public List<Message> getAllMessages(){
        List<Message> allMessages = new ArrayList<>();
        try (Connection conn = ConnectionUtil.getConnection()) {
            String allQry = "Select * from Message";
            PreparedStatement ps = conn.prepareStatement(allQry);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Message objMsg = new Message();
                objMsg.setMessage_id(rs.getInt("message_id"));
                objMsg.setMessage_text(rs.getString("message_text"));
                objMsg.setPosted_by(rs.getInt("posted_by"));
                objMsg.setTime_posted_epoch(rs.getLong("time_posted_epoch"));
                allMessages.add(objMsg);
            }
            return allMessages;
        } catch (Exception e) {
            allMessages = new ArrayList<>();
        }

        return allMessages;
    };
    
    public Message getMessageById(int msgId){
        Message msg = new Message();

        return msg;
    };
    
    public Message deleteMessage(int msgId){
        Message msg = new Message();

        return msg;

    };
    
    public Message updateMessage(int msgId){
        Message msg = new Message();

        return msg;
    };
    
    public List<Message> getAllMessagesByAccountId(int accountId){
        List<Message> allMessages = new ArrayList<>();
        return allMessages;
    };
}
