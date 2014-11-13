<%@page import="java.util.*,index.IndexServlet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2>Latest Announcement</h2>
        <table>
            <tr>
            <div align=left>
                <marquee scrollamount="1" scrolldelay="60" direction="up" width="300" height="152">
                    <font><b><center>Notification</center></b></font><BR><BR>
                    <font><center>Welcome to research management application</center></font><BR>
                    <font><center>By Jialiang Chang</center><BR>
                    </font>
                    <p>
                </marquee></div>
        </tr>

    


    </table>
<!--    <h2>User Login</h2>
    <table>
        <tr>
            <td><a href="login/login.jsp">Login</a></td>
        </tr>
    </table>-->
    <h2>Sign Up</h2>
    <table>
        <tr>
            <td>
   
                 <a href="SignupServlet">Sign Up</a>(Unavailable now)</td> 
        </tr>
    </table>
    <h2>Research</h2>
    <table>
        
        <tr>
            <td><a href="AddResearchServlet">Add Research</a></td>
        </tr>
        <tr>
            <td><a href="SearchServlet">Search</a></td>
        </tr>
    </table>
    <h2>Announcement</h2>
    <table>
        
        <tr>
            <td><a href="AnnouncementServlet">Add announcement</a></td>
        </tr>
        
    </table>
</body>
</html>
