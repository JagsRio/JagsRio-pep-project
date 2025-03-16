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
                createdAccount.account_id=createdAccountId;
                createdAccount.username=username;
                createdAccount.password=password;
                return createdAccount;
            } else {
                createdAccount = null;
                return createdAccount;
            }
            

        } catch (SQLException e) {
            createdAccount = null;
        }
        
        return createdAccount;

    }  

    @Override
    public Account userLogin(String userName, String password) {
        Account loggedInAccount = new Account();
        
        try (Connection conn = ConnectionUtil.getConnection()) {
            String getAcct = "Select * from account where username=? and password=?";
            PreparedStatement ps = conn.prepareStatement(getAcct);
            ps.setString(1, userName);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                loggedInAccount.setAccount_id(rs.getInt("account_id"));
                loggedInAccount.setUsername(rs.getString("username"));
                loggedInAccount.setPassword(rs.getString("password"));
            }
            return loggedInAccount;

        } catch (SQLException e) {
            loggedInAccount= null;
        }

        return loggedInAccount;
    }
    
}
