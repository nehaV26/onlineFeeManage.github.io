/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class SelectAcc {

    private List<User> users;
    public List<User> getAllUser() throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neha", "root", "");
            Statement stmt = con.createStatement();
            users=new ArrayList<User>();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `registation`");
            while(rs.next()){
           User user=new User();
            //user.setId(rs.getInt("id"));
           // user.setName("name");
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            users.add(user);
        }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelectAcc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
}
