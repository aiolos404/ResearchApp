<%-- 
    Document   : addUserPermission
    Created on : Nov 11, 2014, 5:28:10 PM
    Author     : aiolos404
--%>
<!--This page helps admin to add new user group and set the group's CRUB permission-->
<%@page import="java.util.*,permission.UserPermission"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add group and permission</title>
    </head>
    <body>
        <!--number,name,type,date,author,publisher-->
     <!--<a href="../index.jsp" style="text-decoration: none">Back to index</a>-->
     <form method="POST" action="../AddUserGroupServlet">
            Groupname: <input type="text" name="group" /><br>
            Create: <input type="text" name="create" /><br>
            Read: <input type="text" name="read" /><br>
            Update: <input type="text" name="update" /><br>
            Delete: <input type="textarea" name="delete" /><br>
            <input type="submit" value="Add" />
        </form>
       
    </body>
</html>
