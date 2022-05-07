<%-- 
    Document   : addAcc
    Created on : Nov 2, 2021, 11:14:45 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add accountant</title>

    </head>
    <body >
        <%@include file="header2.jsp" %>
        <br>
        <br>
         <div align="center">
             <h1>Add Accountant</h1><br>
  <form action="registerAccServlet" method="post">
      <%String sucssMsg=(String)session.getAttribute("sucssMsg");
          String RegError=(String)session.getAttribute("RegError");
             if(sucssMsg!=null){
                 %>
                 <p class="text-success text-center"><%=sucssMsg%></p>
                 
             <%
                session.removeAttribute("sucssMsg"); }

              if(RegError!=null){
             %>
             
             <p class="text-danger text-center"><%=RegError%></p>
             <%
                 session.removeAttribute("RegError"); }
             %>
             
             <br>
   <table style="with: 80%">
    
    <tr>
     <td> Name:</td>
     <td><input type="text" name="name" /></td>
    </tr>
    <tr>
     <td>Email:</td>
     <td><input type="text" name="email" required="required"/></td>
    </tr>
    <tr>
     <td>Password:</td>
     <td><input type="password" name="password" required="required"/></td>
    </tr>
 
    
   </table><br>
   <input type="submit" value="Add" />&nbsp
   <input type="reset" value="reset" />
  </form>
             
 </div>
    </body>
</html>
