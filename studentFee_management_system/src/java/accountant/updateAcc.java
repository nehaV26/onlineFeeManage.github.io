/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class updateAcc extends HttpServlet {

    

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           int id=Integer.parseInt(request.getParameter("id"));
           String name = request.getParameter("name");
           String email = request.getParameter("email");
           String password = request.getParameter("password");
           //make user object
           User userModel = new User(id,name, email, password);
  
           //create a database model
            userdatabase regUser = new userdatabase(connectionpro.getConnection());
           if (regUser.updateUser(userModel)) {
               HttpSession session = request.getSession();
               session.setAttribute("sucssMsg","register successfully");
               response.sendRedirect("viewAcc.jsp");
              
               SelectAcc acc=new SelectAcc();
               List<User> list;
            try {
                list = acc.getAllUser();
                session.setAttribute("list", list);
            } catch (SQLException ex) {
                Logger.getLogger(updateAcc.class.getName()).log(Level.SEVERE, null, ex);
            }
               
              
              
         } else {
               String errorMessage = "User Available";
               HttpSession regSession = request.getSession();
               regSession.setAttribute("RegError", errorMessage);
               response.sendRedirect("register.jsp");
    }
            
        }
        

    


}
