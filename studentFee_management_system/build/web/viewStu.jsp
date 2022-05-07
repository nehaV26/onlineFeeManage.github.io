<%-- 
    Document   : viewStu
    Created on : Nov 2, 2021, 11:16:34 PM
    Author     : hp
--%>

<%@page import="model.vser"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view student</title>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>
    <body>
        <%@include file="header3.jsp" %>
       
        <div align="center"><br>
            
            <h1> List of students </h1>
           
        <table border="1" cellpadding="5" width="80%" >
            
            <tr>
                <th>Roll no</th>
                <th>Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Course</th>
                <th>Fee</th>
                <th>Paid</th>
                <th>Due</th>
                <th>Address</th>
                <th>Contact</th>
                <th>Action</th>
            </tr>
           <% List<vser> users=(List<vser>)session.getAttribute("list");
            for(vser user:users){
            %>
                <tr>   

                    <td><%=user.getRoll()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getGender()%></td>
                    <td><%=user.getCourse()%></td>
                    <td><%=user.getFee()%></td>
                    <td><%=user.getPaid()%></td>
                    <td><%=user.getDue()%></td>
                    <td><%=user.getAddress()%></td>
                    <td><%=user.getContect()%></td>
                    
        
                    
                    <td>
                    	<a href="editStu.jsp?roll=<%=user.getRoll()%>">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="deleteStu.jsp?roll=<%=user.getRoll()%>">Delete</a>                    	
                    </td>   
                </tr>
                <%
                    }
                %>
            
        </table>
    </div>	
        
    </body>
</html>
