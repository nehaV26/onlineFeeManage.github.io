<%-- 
    Document   : student
    Created on : Nov 10, 2021, 10:32:18 PM
    Author     : hp
--%>

<%@page import="model.vser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% vser user=(vser)session.getAttribute("selectUser");
if(user==null){
    response.sendRedirect("searchStu.jsp");
}
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>student details</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>
    <body>
        <nav>
            <input type="checkbox" id="check" >
            <label for="check" class="checkbtn">
                <i class="fas fa-bars"></i>
            </label>
            
        <label class="logo">FeesManageApp</label>
            <ul>
                <li><a  class="active" href="searchStu.jsp">back</a></li>
                
            </ul>
        </nav>
       
    <center> <br>
         <br>
        
        <table border="1"  width="30%" text-align: center>
            <tr><td colspan="2"><center><h1>student details</h1></center><tr>
                <tr>
                    <td >Roll no:</td><td><%=user.getRoll()%></td>
                    
                </tr>
                <tr>
                    <td >Name:</td>
                    <td><%=user.getName()%></td>
                </tr>
                <tr>
                    <td >Email:</td>
                    <td><%=user.getEmail()%></td>
                </tr>
                <tr>
                    <td >Gender:</td>
                    <td><%=user.getGender()%></td>
                </tr>
                <tr>
                    <td >Course:</td>
                    <td><%=user.getCourse()%></td>
                </tr>
                <tr>
                    <td >Fee:</td>
                    <td><%=user.getFee()%></td>
                </tr>
                <tr>
                    <td >Paid</td>
                    <td><%=user.getPaid()%></td>
                </tr>
                <tr>
                    <td >Due:</td>
                    <td><%=user.getDue()%></td>
                </tr>
                <tr>
                    <td >Address:</td>
                    <td><%=user.getAddress()%></td>
                </tr>
                <tr>
                    <td >Contact</td>
                    <td><%=user.getContect()%></td>
                </tr>
            
        </table>
    </center>
    </body>
</html>
