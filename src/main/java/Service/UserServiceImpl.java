package Service;

import DAO.UserDAO;
import DAO.userDAOImpl;
import Model.Account;

public class UserServiceImpl implements UserService {

    private UserDAO userDao = new userDAOImpl();

    @Override
    public Account createAccount(String username, String password) {
        Account newAccount = new Account();
        if (username.length()==0){
            newAccount = null;
            return newAccount;
        }
        if (password.length()==0){
            newAccount = null;
            return newAccount;
        }
        if (password.length()>3){
            newAccount = userDao.createAccount(username, password);
        }
        else{
            newAccount = null;
        }
        return newAccount;
    }


    @Override
    public Account userLogin(String userName, String password) {
        Account loggedInAccount = new Account();
        loggedInAccount = userDao.userLogin(userName, password);
        String logAcctUsername;
        String logAcctPassword;

        if (loggedInAccount != null){
            logAcctUsername = loggedInAccount.getUsername();
            logAcctPassword = loggedInAccount.getPassword();
            if (logAcctUsername != null){
                if (logAcctUsername.equals(userName)){
                    if (logAcctPassword != null){
                        if (logAcctPassword.equals(password)){
                            return loggedInAccount;
                        } else loggedInAccount=null;

                    } else loggedInAccount=null;

                } else loggedInAccount=null;

            } else loggedInAccount=null;
        }
        return loggedInAccount;
    }
    
}
