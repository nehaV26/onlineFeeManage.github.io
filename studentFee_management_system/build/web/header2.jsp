<%-- 
    Document   : header2
    Created on : Nov 2, 2021, 9:04:42 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body >
        <nav>
            <input type="checkbox" id="check" >
            <label for="check" class="checkbtn">
                <i class="fas fa-bars"></i>
            </label>

            <label class="logo">FeesManageApp</label>
            <ul>
                <li><a  class="active" href="home1.jsp">Home</a></li>
                <li><a href="addAcc.jsp">add accountant</a></li>
                <li><a href="viewAcc.jsp">view accountant </a></li>
                <li><a href="admin.jsp">logout</a></li>
            </ul>
        </nav>
                
        

    </body>
</html>
