
package ge.mziuri.dao;

import ge.mziuri.model.User;
import java.sql.Connection;

public class UserDAOImpl implements UserDAO{
    
    private Connection con;
    
    public UserDAOImpl() {
        con = DatabaseUtil.getConnection();
    }

    @Override
    public void register(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User login(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
