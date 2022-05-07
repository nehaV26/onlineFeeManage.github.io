<%-- 
    Document   : admin
    Created on : Nov 1, 2021, 7:33:59 AM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>admin login</title>
        <style>
            div{
                text-align: center;
            }
        </style>
    </head>
    <body >
        <%@include file="header1.jsp" %>
        
        <div>
            <br>
            <br>

            <h1>
                Admin Login</h1>
            <form action="addServlet" method="post"><br>
                
                      
                    <label> Username:</label>&nbsp
                <input type="text" placeholder="Username/email" name="email" required><br><br>
                    
                <label> Password:</label>&nbsp<input type="password" placeholder="Password" name="password" required><br><br>
                    <input type="submit" value="Login">&nbsp 
                    <input type="reset" value="reset">
                
                  

            </form>
           
        </div> 

    </body>
</html>








                
                
          

                