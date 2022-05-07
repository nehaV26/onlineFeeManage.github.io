/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import static java.lang.System.out;
import model.vser;
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
public class setectStu {

    private List<vser> users;

    public List<vser> getAllUser() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neha", "root", "");
            Statement stmt = con.createStatement();
            users = new ArrayList<vser>();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `student`");
            while (rs.next()) {
                vser user = new vser();
                //user.setId(rs.getInt("id"));
                // user.setName("name");
                user.setRoll(rs.getInt("roll no"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                
                user.setGender(rs.getString("gender"));
                user.setCourse(rs.getString("course"));
                user.setFee(rs.getInt("fee"));
                 user.setPaid(rs.getInt("paid"));
                  user.setDue(rs.getInt("due"));
                
                user.setAddress(rs.getString("address"));
                user.setContect(rs.getInt("contact"));
              
                
                users.add(user);
            }

        } catch(Exception e){
            out.println(e);
        }
        return users;
    }
}
