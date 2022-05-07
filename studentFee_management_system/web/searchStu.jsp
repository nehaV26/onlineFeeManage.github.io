<%-- 
    Document   : searchStu
    Created on : Nov 2, 2021, 11:16:58 PM
    Author     : hp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>search student</title>
        <style>
            div{
                text-align: center;
            }
        </style>
    </head>
    <body>
        <%@include file="header3.jsp" %><br>
        <div> 
        <h1>search student</h1>
        <form action="findStu" method="post"><br>
                <label>
                              Roll No:</label>&nbsp<input type="text"  name="roll" required><br><br>
                   
                  <input type="submit" value="search">&nbsp 
                            <input type="reset" value="reset">
                
            </form>
        </div>
    </body>
</html>
