<%-- 
    Document   : search
    Created on : Oct 21, 2014, 9:23:25 PM
    Author     : aiolos404
--%>
<%@page import="java.util.*,research.Search"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="index.jsp" style="text-decoration: none">Back to index</a>
        
     
        <hr><ol> <%

            List<Search> researches = (List<Search>)request.getAttribute("researches");
            for (Search u : researches) { %>
                <li> <%= u %> </li> <%
            } %>
        </ol><hr>
            
    </body>
</html>
