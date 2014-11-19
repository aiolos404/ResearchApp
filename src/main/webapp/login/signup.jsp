<%-- 
    Document   : signup
    Created on : Nov 11, 2014, 5:09:43 PM
    Author     : aiolos404
--%>
<!--This page could help new or existing user to sigh up a new account-->
<%@page import="java.util.*,user.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
    </head>
    <body>
        <!--number,name,type,date,author,publisher-->
     <a href="index.jsp" style="text-decoration: none">Back to index</a>
     <form method="POST" action="SignupServlet">
            Firstname: <input type="text" name="firstname" /><br>
            Lastname: <input type="text" name="lastname" /><br>
            Email: <input type="text" name="email" /><br>
            Username: <input type="text" name="username" /><br>
            Password: <input type="text" name="password" /><br>
            Confirm password <input type="text" name="password" /><br>
            <input type="submit" value="Add" />
        </form>
            
    </body>
</html>
