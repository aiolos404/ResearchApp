<%-- 
    Document   : viewUserPermission
    Created on : Nov 18, 2014, 8:50:02 AM
    Author     : aiolos404
--%>
<!--view groups and their permissions-->
<%@page import="permission.UserPermission"%>
<%@ page import="java.util.*" %> 
<html>
    <head>
        <title>View group and permission</title>
    </head>
    <body>
<!--         <a href="admin/adminPanel.jsp" style="text-decoration: none">Back to index</a>-->
        <hr><ol> <%

            List<UserPermission> permission = (List<UserPermission>)request.getAttribute("userPermissions");
            for (UserPermission u : permission) { 
        %>
                <li> <%= u%> </li> <%
            } %>
        </ol><hr>
    </body>
</html>