<%-- 
    Document   : viewSearch
    Created on : Nov 13, 2014, 1:50:25 PM
    Author     : aiolos404
--%>

<%@page import="research.Research"%>
<%@ page import="java.util.*" %> 
<html>
    <head>
    </head>
    <body>

        <hr><ol> <%

            List<Research> researches = (List<Research>)request.getAttribute("researches");
            for (Research u : researches) { 
        %>
                <li> <%= u %> </li> <%
            } %>
        </ol><hr>
    </body>
</html>