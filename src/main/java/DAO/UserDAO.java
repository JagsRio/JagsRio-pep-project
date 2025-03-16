package DAO;
import Model.Account;

public interface UserDAO {
    public abstract Account createAccount(String username, String password);
    public abstract int userLogin(Account userAccount);
}
