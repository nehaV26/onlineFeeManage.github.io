<%-- 
    Document   : addStu
    Created on : Nov 2, 2021, 11:16:17 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add student</title>
    </head>
    <body>
        <%@include file="header3.jsp" %><br>
        

        <div align="center">
            <h1>Add Student</h1><br>
            <form action="UserServlet" method="post">
                
                <%String sucssMsg=(String)session.getAttribute("sucssMsg");
             if(sucssMsg!=null){
                 %>
                 <p class="text-success text-center"><%=sucssMsg%></p>
             <%
                session.removeAttribute("sucssMsg"); }
             %><br>
                <table style="with: 80%">
                    <tr>
                        <td> Roll no:</td>
                        <td><input type="text" name="roll" required="required"/></td>
                    </tr>
                    
                    <tr>
                        <td> Name:</td>
                        <td><input type="text" name="name" required="required"/></td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr><td><label for="radio">Gender:</lable></td><td>
<input type="radio" name="radiobtn" value="male" id="radio" >male
<input type="radio" name="radiobtn" value="female" id="radio">female</td></tr>
                    <tr>
                        <td>Course:</td>
                        <td><input type="text" name="course"/></td>
                    </tr>
                    <tr>
                        <td> Fee:</td>
                        <td><input type="text" name="fee" /></td>
                    </tr>
                    <tr>
                        <td>Paid:</td>
                        <td><input type="text" name="paid" /></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><textarea rows="3" cols="21" name="address"></textarea>
                                </td>
    </tr>
    <tr>
     <td>Contact:</td>
     <td><input type="text" name="contact" required="required"/></td>
    </tr>
 
    
   </table><br>
   <input type="submit" value="Add" />&nbsp
   <input type="reset" value="reset" />
  </form>
 </div>
    </body>
</html>
