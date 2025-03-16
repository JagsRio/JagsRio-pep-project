package Service;

import DAO.UserDAO;
import DAO.userDAOImpl;
import Model.Account;

public class UserServiceImpl implements UserService {

    private UserDAO userDao = new userDAOImpl();

    @Override
    public Account createAccount(String username, String password) {
        Account newAccount = new Account();
        if (password.length()>3){
         newAccount = userDao.createAccount(username, password);
        }
        else{
            newAccount = null;
        }
        return newAccount;
    }


    @Override
    public int userLogin(Account userAcct) {
        int accountId = -1;

        return accountId;
    }
    
}
