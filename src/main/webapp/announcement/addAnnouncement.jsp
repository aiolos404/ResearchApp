<%-- 
    Document   : addAnnouncement
    Created on : Nov 11, 2014, 5:28:10 PM
    Author     : aiolos404
--%>

<%@page import="java.util.*,announcement.Announcement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--number,name,type,date,author,publisher-->
     <a href="index.jsp" style="text-decoration: none">Back to index</a>
     <form method="POST" action="AnnouncementServlet">
            Publisher: <input type="text" name="publisher" /><br>
            Content: <input type="textarea" name="content" /><br>
            Time: <input type="text" name="publish_time" /><br>
 
            <input type="submit" value="Add" />
        </form>
             <hr><ol> <%

            List<Announcement> announcement = (List<Announcement>)request.getAttribute("announcement");
            for (Announcement u : announcement) { %>
                <li> <%= u %> </li> <%
            } %>
        </ol><hr>
    </body>
</html>
