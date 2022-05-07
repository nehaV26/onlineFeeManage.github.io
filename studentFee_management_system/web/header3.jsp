<%-- 
    Document   : header3
    Created on : Nov 2, 2021, 9:04:58 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <input type="checkbox" id="check" >
            <label for="check" class="checkbtn">
                <i class="fas fa-bars"></i>
            </label>

            <label class="logo">FeesManageApp</label>
            <ul>
                <li><a  class="active" href="home2.jsp">Home</a></li>
                <li><a href="addStu.jsp">add student </a></li>
                <li><a href="viewStu.jsp">view students</a></li>
                <li><a href="searchStu.jsp">search student</a></li>
                <li><a href="accountant.jsp">logout</a></li>
            </ul>
        </nav>

    </body>
</html>
