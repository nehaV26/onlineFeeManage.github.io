/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author hp
 */
public class connectionpro {
     private static Connection con;
    public static Connection getConnection() {
        
        try{
            
        
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neha","root","");
			
	   Statement stmt=con.createStatement();
    
        }
       catch(ClassNotFoundException | SQLException e){
	 System.out.println(e);
        }
        return con;
        
    }
    
}
