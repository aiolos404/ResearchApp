<%-- 
    Document   : viewAnnouncements
    Created on : Nov 13, 2014, 1:50:25 PM
    Author     : aiolos404
--%>
<!--Announcements view page-->
<%@page import="announcement.Announcement"%>
<%@ page import="java.util.*" %> 
<html>
    <head>
        <title>View announcement</title>
    </head>
    <body>
<!--         <a href="admin/adminPanel.jsp" style="text-decoration: none">Back to index</a>-->
        <hr><ol> <%

            List<Announcement> announcement = (List<Announcement>)request.getAttribute("announcements");
            for (Announcement u : announcement) { 
        %>
                <li> <%= u%> </li> <%
            } %>
        </ol><hr>
    </body>
</html>