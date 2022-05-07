<%-- 
    Document   : delete
    Created on : Nov 10, 2021, 1:15:35 AM
    Author     : hp
--%>


<%@page import="accountant.User"%>
<%@page import="java.util.List"%>
<%@page import="accountant.SelectAcc"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="java.sql.Statement " %>
<%@page import ="java.sql.Connection" %>
<%@page import ="java.sql.DriverManager " %>
<%
    int id=Integer.parseInt(request.getParameter("id"));
   Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neha","root","");    
      Statement stmt = con.createStatement();
      stmt.executeUpdate("delete from `registation` where id='"+id+"'");
               SelectAcc acc=new SelectAcc();
               List<User> list=acc.getAllUser();
               session.setAttribute("list", list);
      response.sendRedirect("viewAcc.jsp");
%>

