<%-- 
    Document   : viewMetaData
    Created on : Nov 13, 2014, 1:50:25 PM
    Author     : aiolos404
--%>
<!--view metadata page-->
<%@page import="metadata.Meta"%>
<%@ page import="java.util.*" %> 
<html>
    <head>
        <title>view metadata</title>
    </head>
    <body>
<!--         <a href="../admin/adminPanel.jsp" style="text-decoration: none">Back to index</a>-->
        <hr><ol> <%

            List<Meta> meta = (List<Meta>)request.getAttribute("metas");
            for (Meta u : meta) { 
        %>
                <li> <%= u%> </li> <%
            } %>
        </ol><hr>
    </body>
</html>