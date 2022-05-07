<%-- 
    Document   : deleteStu
    Created on : Nov 11, 2021, 7:49:54 AM
    Author     : hp
--%>

<%@page import="model.vser"%>
<%@page import="java.util.List"%>
<%@page import="web.setectStu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@page import ="java.sql.Statement" %>
        <%@page import ="java.sql.Connection" %>
        <%@page import ="java.sql.DriverManager" %>
        <%
            int id = Integer.parseInt(request.getParameter("roll"));
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neha", "root", "");
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from `student` where `roll no`='" + id + "'");
            setectStu acc = new setectStu();
            List<vser> list = acc.getAllUser();
            session.setAttribute("list", list);
            response.sendRedirect("viewStu.jsp");
        %>


    </body>
</html>
