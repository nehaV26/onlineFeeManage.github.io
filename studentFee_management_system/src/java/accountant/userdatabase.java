/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hp
 */
public class userdatabase {
    Connection con ;

    public userdatabase(Connection con) {
        this.con = con;
    }
    
    //registration code heare write;
    public boolean saveUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "insert into `registation`(name,email,password) values(?,?,?)";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setString(1, user.getName());
           pt.setString(2, user.getEmail());
           pt.setString(3, user.getPassword());
           
           pt.executeUpdate();
           set = true;
        }catch(SQLException e){
            out.println(e);
        }
        return set;
    }
    
    
    
    
    
    public User loguser(String email,String pass){
        User user=null;
        try{
            String query=" SELECT * FROM `registation` WHERE email=? AND password=? ";
            PreparedStatement pst=this.con.prepareStatement(query);
            pst.setString(1,email);
            pst.setString(2,pass);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
            user=new User();
            //user.setId(rs.getInt("id"));
           // user.setName("name");
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }
        
            
        }
            
        catch(SQLException e){
            out.println(e);
        }
         return user;
        }
         
          public boolean updateUser(User user){
        boolean set = false;
        try{
            //Insert register data to database
            String query = "UPDATE `registation` SET `name`='"+user.getName()+"',`email`='"+user.getEmail()+"',`password`='"+user.getPassword()+"' WHERE id='"+user.getId()+"'";
           
           PreparedStatement pt = this.con.prepareStatement(query);
           
           
           pt.executeUpdate();
           set = true;
        }catch(SQLException e){
            out.println(e);
        }
        return set;
    
    }
    
}
