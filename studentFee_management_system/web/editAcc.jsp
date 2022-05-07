<%-- 
    Document   : editAcc
    Created on : Nov 10, 2021, 9:22:38 PM
    Author     : hp
--%>
<%@page import="java.sql.DriverManager"%>
<%@page import="accountant.User"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List"%>
<%@page import="accountant.SelectAcc"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit accountant</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <nav>
            <input type="checkbox" id="check" >
            <label for="check" class="checkbtn">
                <i class="fas fa-bars"></i>
            </label>
            
        <label class="logo">FeesManageApp</label>
            <ul>
                <li><a  class="active" href="viewAcc.jsp">back</a></li>
                
            </ul>
        </nav>
       
        <br>
        <br>
         <div align="center">
             <h1>Edit Accountant</h1><br>      
         
        
        <%
    int id=Integer.parseInt(request.getParameter("id"));
   Class.forName("com.mysql.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/neha","root","");    
      Statement stmt = con.createStatement();
      
      
       ResultSet rs = stmt.executeQuery("SELECT * FROM `registation` WHERE `id`='"+id+"'");
               
              while (rs.next()) { %>
              
              
                          
  <form action="updateAcc" method="post">
      <br>
   <table style="with: 80%">
       <tr>
     <td> </td>
     <td><input type="hidden" name="id" value="<%=rs.getInt("id")%>" /></td>
    </tr>
    
    <tr>
     <td> Name:</td>
     <td><input type="text" name="name" value="<%=rs.getString("name")%>" /></td>
    </tr>
    <tr>
     <td>Email:</td>
     <td><input type="text" name="email" required="required" value="<%=rs.getString("email")%>"/></td>
    </tr>
    <tr>
     <td>Password:</td>
     <td><input type="password" name="password" required="required" value="<%=rs.getString("password")%>"/></td>
     
    </tr>
 
    
   </table><br>
   <input type="submit" value="update" />
   <input type="reset" value="reset" />
  
  </form>
                
                
           <%   }
       
       
               SelectAcc acc=new SelectAcc();
               List<User> list=acc.getAllUser();
               session.setAttribute("list", list);
      //response.sendRedirect("viewAcc.jsp");
%>

        
        
        
        
        
        
        
        
        
        
        
        
         
 
             
 </div>
   
    </body>
</html>
