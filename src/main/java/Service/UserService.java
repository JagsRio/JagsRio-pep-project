package Service;

import Model.Account;

public interface UserService {
    public abstract Account createAccount(String username, String password);
    public abstract Account userLogin(String userName, String password);
}