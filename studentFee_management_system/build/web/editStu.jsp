<%-- 
    Document   : editStu
    Created on : Nov 11, 2021, 9:10:30 AM
    Author     : hp
--%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.vser"%>
<%@page import="java.util.List"%>
<%@page import="web.setectStu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit student</title>
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
                <li><a  class="active" href="viewStu.jsp">back</a></li>

            </ul>
        </nav>


        <div align="center">
            <br>      


            <%
                int id = Integer.parseInt(request.getParameter("roll"));
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/neha", "root", "");
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT * FROM `student` WHERE `roll no`='" + id + "'");

                while (rs.next()) {%>



            <div align="center">
                <h1>Edit Student</h1>
                
                <form action="updateStu" method="post">
                    <table style="with: 80%">
                        <tr>
                            <td> Roll no:</td>
                            <td><input type="text" name="roll" required="required" value="<%=rs.getInt("roll no")%>"/></td>
                        </tr>

                        <tr>
                            <td> Name:</td>
                            <td><input type="text" name="name" required="required" value="<%=rs.getString("name")%>"/></td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td><input type="text" name="email" value="<%=rs.getString("email")%>"/></td>
                        </tr>
                        <tr><td><label for="radio">Gender:</lable></td><td>
                                <input type="radio" name="radiobtn" value="male" id="radio" >male
                                <input type="radio" name="radiobtn" value="female" id="radio">female</td></tr>
                        <tr>
                            <td>Course:</td>
                            <td><input type="text" name="course" value="<%=rs.getString("course")%>"/></td>
                        </tr>
                        <tr>
                            <td> Fee:</td>
                            <td><input type="text" name="fee" value="<%=rs.getInt("fee")%>"/></td>
                        </tr>
                        <tr>
                            <td>Paid:</td>
                            <td><input type="text" name="paid" value="<%=rs.getInt("paid")%>"/></td>
                        </tr>
                        <tr>
                            <td>Address:</td>
                            <td><textarea rows="3" cols="21" name="address" ><%=rs.getString("address")%></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>Contact:</td>
                            <td><input type="text" name="contact" required="required" value="<%=rs.getInt("contact")%>"/></td>
                        </tr>


                    </table><br>
                    <input type="submit" value="Add" />&nbsp
                    <input type="reset" value="reset" />
                </form>
            </div>
            <%  }

                setectStu acc = new setectStu();
                List<vser> list = acc.getAllUser();
                session.setAttribute("list", list);
                //response.sendRedirect("viewAcc.jsp");
%>
















        </div>
    </body>
</html>
