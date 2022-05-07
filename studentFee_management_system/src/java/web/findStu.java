/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vser;

/**
 *
 * @author hp
 */
public class findStu extends HttpServlet {

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
       int roll=Integer.parseInt(request.getParameter("roll"));
      vser user=null;
       try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neha", "root", "");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `roll no`, `name`, `email`, `gender`, `course`, `fee`, `paid`, `due`, `address`, `contact` FROM `student` WHERE `roll no`='"+roll+"' "); 
            
            if(rs.next()){
                int rollno=rs.getInt("roll no");
                String name=rs.getString("name");
                String email=rs.getString("email");
                String gender=rs.getString("gender");
                String course=rs.getString("course");
                int fee=rs.getInt("fee");
                int paid=rs.getInt("paid");
                int due=rs.getInt("due");
                String address=rs.getString("address");
                int contect=rs.getInt("contact");
               user=new vser(rollno,name,email,gender,course,fee,paid,due,address,contect);
                
            }
                HttpSession session=request.getSession();
                session.setAttribute("selectUser",user);
                response.sendRedirect("student.jsp");
            
        }catch(ClassNotFoundException | SQLException e){
            out.println(e);
        }
       out.print("roll:="+roll); 
       
    }
       
       
       
       
               
      
    
    
           
}
