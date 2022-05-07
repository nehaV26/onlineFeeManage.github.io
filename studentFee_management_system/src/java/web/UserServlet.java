/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Dao.UserDAO;
import java.io.IOException;
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

/**
 *
 * @author hp
 */
public class UserServlet extends HttpServlet {

    private UserDAO userDAO;

    public UserServlet() {
        this.userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        int roll=Integer.parseInt(request.getParameter("roll"));
        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String gender=request.getParameter("radiobtn");
        String course=request.getParameter("course");
        int fee=Integer.parseInt(request.getParameter("fee"));
        int paid=Integer.parseInt(request.getParameter("paid"));
        int due=fee-paid;
        String address=request.getParameter("address");
        int contect=Integer.parseInt(request.getParameter("contact"));
        vser newUser=new vser(roll,name,email,gender,course,fee,paid,due,address,contect);
        try {
            userDAO.insertUser(newUser);
            
        } catch (SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        HttpSession session=request.getSession();
            setectStu acc=new setectStu();
               List<vser> list;
        try {
            list = acc.getAllUser();
             session.setAttribute("list", list);
        } catch (SQLException ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
              
               session.setAttribute("sucssMsg","add student successfully");
               
                  
                 response.sendRedirect("addStu.jsp");
        
        
        
        
        
    }

    }

    
