package DAO;

import Model.Account;
import Util.ConnectionUtil;
import java.sql.*;

public class userDAOImpl implements UserDAO {

    @Override
    public Account createAccount(String username, String password) {
        Account createdAccount = new Account();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sqlQuery = "Insert into account(username,password) values (?,?)";
            PreparedStatement ps = conn.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, username);
            ps.setString(2, password);
            int addedRow = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int createdAccountId = -1;
            if (addedRow==1){
                while (rs.next()){
                    createdAccountId = rs.getInt(1);
                }
            }
            createdAccount.account_id=createdAccountId;
            createdAccount.username=username;
            createdAccount.password=password;
            return createdAccount;

        } catch (Exception e) {
            createdAccount = null;
        }
        
        return createdAccount;

    }

    @Override
    public int userLogin(Account userAccount) {
        int accountId = -1;

        return accountId;
    }
    
}
