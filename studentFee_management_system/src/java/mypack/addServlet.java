/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import accountant.SelectAcc;
import accountant.User;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hp
 */
public class addServlet extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           String email=request.getParameter("email");
           String pass=request.getParameter("password");
         //  response.sendRedirect("home1.jsp");
             
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neha", "root", "");
            PreparedStatement stmt = con.prepareStatement(" SELECT * FROM `form` WHERE username=? AND password=? ");
           stmt.setString(1, email);
           stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
               // int n = rs.getInt("id");
               // String nm = rs.getString("name");
              //  int m = rs.getInt("mobile");
               // out.println("<tr><td>" +n+ "</td><td>" + nm + "</td></tr>");
               HttpSession session=request.getSession();
               SelectAcc acc=new SelectAcc();
               List<User> list=acc.getAllUser();
               session.setAttribute("list", list);
             
               
               response.sendRedirect("home1.jsp");
            }
            else{
                out.println("error");
            }
            
            
            } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(addServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

}
