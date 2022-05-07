<%-- 
    Document   : viewAcc
    Created on : Nov 2, 2021, 11:15:05 PM
    Author     : hp
--%>

<%@page import="java.util.List"%>
<%@page import="accountant.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view accountant</title>
         <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>
    <body>
        <%@include file="header2.jsp" %>
        
        <div align="center"><br>
            
            <h1> List of Accountant </h1>
           <br>
        <table border="1" cellpadding="5" width="60%">
            
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Action</th>
                
            </tr>
            <% List<User> users=(List<User>)session.getAttribute("list");
            for(User user:users){
            %>
                <tr>   

                    <td><%=user.getId()%></td>
                    <td><%=user.getName()%></td>
                    <td><%=user.getEmail()%></td>
                    <td><%=user.getPassword()%></td>
                    
        
                    
                    <td>
                    	<a href="editAcc.jsp?id=<%=user.getId()%>">Edit</a>
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	<a href="delete.jsp?id=<%=user.getId()%>">Delete</a>                    	
                    </td>
                </tr>
                <%
                    }
                %>
            </c:forEach>
        </table>
    </div>	
    </body>
</html>




