<%-- 
    Document   : viewSearch
    Created on : Nov 13, 2014, 1:50:25 PM
    Author     : aiolos404
--%>
<!--Show the search results from the searchResearch.jsp-->
<%@page import="research.Research"%>
<%@ page import="java.util.*" %> 
<html>
    <head>
        <title>View research</title>
    </head>
    <body>
<!--         <a href="index.jsp" style="text-decoration: none">Back to index</a><br/>-->
        <tr style="background-color:lightgrey;">
                <td><b>Number</b></td>
                <td><b>Name</b></td>
                <td><b>Type</b></td>
                <td><b>Date</b></td>
                <td><b>Author</b></td>  
                <td><b>Publisher</b></td>

        </tr>
        <hr> <%

            List<Research> researches = (List<Research>)request.getAttribute("researches");
            for (Research u : researches) { 
        %>
                <td> <%= u%> </td><br/> 
               <%
            } %>
        <hr>
    </body>
</html>