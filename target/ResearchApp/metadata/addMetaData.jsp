<%-- 
    Document   : addMetaData
    Created on : Nov 11, 2014, 5:28:10 PM
    Author     : aiolos404
--%>
<!--This page help admin to add metadata of researches-->
<%@page import="java.util.*,metadata.Meta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Meta data of researches</title>
    </head>
    <body>
        <!--number,name,type,date,author,publisher-->
<!--     <a href="../index.jsp" style="text-decoration: none">Back to index</a>-->
     <form method="POST" action="../MetaServlet">
            ISBN: <input type="text" name="isbn" /><br>
            Topic: <input type="textarea" name="topic" /><br>
            Content: <input type="text" name="content" /><br>
 
            <input type="submit" value="Add" />
        </form>
       
    </body>
</html>
