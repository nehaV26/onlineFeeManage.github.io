/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
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
public class updateStu extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int roll = Integer.parseInt(request.getParameter("roll"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("radiobtn");
        String course = request.getParameter("course");
        int fee = Integer.parseInt(request.getParameter("fee"));
        int paid = Integer.parseInt(request.getParameter("paid"));
        int due = fee - paid;
        String address = request.getParameter("address");
        int contect = Integer.parseInt(request.getParameter("contact"));
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neha", "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE `student` SET `name`='"+name+"',`email`='"+email+"',`gender`='"+gender+"',`course`='"+course+"',`fee`='"+fee+"',`paid`='"+paid+"',`due`='"+due+"',`address`='"+address+"',`contact`='"+contect+"' WHERE `roll no`='"+roll+"'");
            
            HttpSession session = request.getSession();
            setectStu acc = new setectStu();
            List<vser> list = acc.getAllUser();
            session.setAttribute("list", list);
            response.sendRedirect("viewStu.jsp");

        } catch (Exception e) {
            out.println(e);
        }

    }

}
