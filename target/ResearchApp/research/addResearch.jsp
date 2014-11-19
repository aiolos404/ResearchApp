<%-- 
    Document   : addResearch
    Created on : Oct 21, 2014, 10:17:42 PM
    Author     : aiolos404
--%>
<!--This page could help user to add new research and new added research will be shown below.-->
<%@page import="research.Research"%>
<%@page import="java.util.*,research.SearchResearchServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add researches</title>
    </head>
    <body>
        <!--number,name,type,date,author,publisher-->
<!--     <a href="index.jsp" style="text-decoration: none">Back to index</a>-->
     <form method="POST" action="AddResearchServlet">
            Number <input type="text" name="Number" /><br>
            Name: <input type="text" name="Name" /><br>
            Type: <input type="text" name="Type" /><br>
            Date: <input type="text" name="Date" /><br>
            Author: <input type="text" name="Author" /><br>
            Publisher <input type="text" name="Publisher" /><br>
            <input type="submit" value="Add" />
        </form>
            <hr><ol> <%

            List<Research> researches = (List<Research>)request.getAttribute("researches");
            for (Research u : researches) { %>
                <li> <%= u %> </li> <%
            } %>
        </ol><hr>
    </body>
</html>
