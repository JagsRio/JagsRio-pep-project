import Controller.SocialMediaController;
import Model.Account;
import Service.UserService;
import Service.UserServiceImpl;
import io.javalin.Javalin;

/**
 * This class is provided with a main method to allow you to manually run and test your application. This class will not
 * affect your program in any way and you may write whatever code you like here.
 */
public class Main {
    public static void main(String[] args) {
        SocialMediaController controller = new SocialMediaController();
        Javalin app = controller.startAPI();
        app.start(8080);

        UserService userService = new UserServiceImpl();
        Account newAccount = new Account();
        newAccount = userService.createAccount("testAgain", "hello");
        System.out.println(newAccount.toString());

    }
}
