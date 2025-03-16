package Controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import Model.Message;
import Model.Account;
import Service.MessageServiceImpl;
import Service.UserServiceImpl;
/**
 * TODO: You will need to write your own endpoints and handlers for your controller. The endpoints you will need can be
 * found in readme.md as well as the test cases. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
public class SocialMediaController {
    /**
     * In order for the test cases to work, you will need to write the endpoints in the startAPI() method, as the test
     * suite must receive a Javalin object from this method.
     * @return a Javalin app object which defines the behavior of the Javalin controller.
     */

    static ObjectMapper objMapper = new ObjectMapper();
    
    public Javalin startAPI() {
        Javalin app = Javalin.create();
        app.get("example-endpoint", this::exampleHandler);

        app.post("login", getLoggedInAccountHandler);
        app.post("register", completeRegistratioHandler);
        app.post("messages", createNewMessageHandler);
        app.get("messages", getAllMessagesFromDBHandler);
        return app;
    }
    //long secondsSinceEpoch = System.currentTimeMillis();
    /**
     * This is an example handler for an example endpoint.
     * @param context The Javalin Context object manages information about both the HTTP request and response.
     */
    private void exampleHandler(Context context) {
        context.json("sample text");
    }

    public static Handler completeRegistratioHandler = ctx ->{
        String jsonAccount = ctx.body();
        Account newAccount = objMapper.readValue(jsonAccount, Account.class);
        String username = newAccount.getUsername();
        String password = newAccount.getPassword();
        UserServiceImpl userImpl = new UserServiceImpl();
        Account createdAccount = userImpl.createAccount(username, password);
        if (createdAccount != null){
            ctx.json(createdAccount).status(200);
        } else ctx.status(400);
    };

    public static Handler getLoggedInAccountHandler = ctx -> {
        String jsonAccount = ctx.body();
        Account loggedAccount = objMapper.readValue(jsonAccount, Account.class);
        String username = loggedAccount.getUsername();
        String password = loggedAccount.getPassword();
        UserServiceImpl userImpl = new UserServiceImpl();
        Account recdAccount = userImpl.userLogin(username, password);
        if (recdAccount != null){
            ctx.json(recdAccount).status(200);
        } 
        else{
            ctx.status(401);
        }        
    };

    public static Handler createNewMessageHandler = ctx -> {
        String jsonString = ctx.body();
        Message newMessage = objMapper.readValue(jsonString, Message.class);
        String messageText = newMessage.getMessage_text();
        long postedTime = newMessage.getTime_posted_epoch();
        int posted_by = newMessage.getPosted_by();
        MessageServiceImpl messageServiceImpl = new MessageServiceImpl();
        Message createdMessage = messageServiceImpl.createMessage(messageText, posted_by, postedTime);
        if (createdMessage !=null){
            ctx.json(createdMessage).status(200);
        }
        else{
            ctx.status(400);
        }
    };

    private static Handler getAllMessagesFromDBHandler = ctx-> {
        List<Message> allMessages = new ArrayList<>();
        MessageServiceImpl messageServiceImpl = new MessageServiceImpl();
        allMessages = messageServiceImpl.getAllMessages();
        ctx.json(allMessages).status(200);
      
    };

}