/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;


import java.io.IOException;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.vser;
import web.setectStu;

/**
 *
 * @author hp
 */
public class loginAccServlet extends HttpServlet {

    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String lemail=request.getParameter("email");
           String lpassword=request.getParameter("password");
           userdatabase db=new userdatabase(connectionpro.getConnection());
            User user=db.loguser(lemail, lpassword);
            if (user!=null){
               HttpSession session=request.getSession();
                session.setAttribute("loguser",user);
                setectStu acc=new setectStu();
               List<vser> list;
           try {
               list = acc.getAllUser();
               session.setAttribute("list", list);
           } catch (SQLException ex) {
               Logger.getLogger(loginAccServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
               
                 
               
                response.sendRedirect("home2.jsp");
            }
            else{
                out.print("user not found");
            }
    }

   

}
