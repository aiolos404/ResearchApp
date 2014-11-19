<%-- 
    Document   : adminPanel
    Created on : Nov 13, 2014, 12:42:36 PM
    Author     : aiolos404
--%>
<!--This is the admin panel where admin could add announcement,group and permission and research metadata-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>
    </head>
    <body>
        <h1>Hello administrator!</h1>
        
        <h2>Announcement Management</h2>
    <table>
        
        <tr>
            <td><a href="announcement/addAnnouncement.jsp">Add announcement</a></td>
        </tr>
<!--        <tr>
            <td><a href="announcement/viewAnnouncements.jsp">view announcements</a></td>
        </tr>
        -->
    </table>
        
        <h2>User Access Permission Management</h2>
    <table>
        
        <tr>
            <td><a href="userpermission/addUserPermission.jsp">Add group and permission</a></td>
        </tr>
     </table>
      
         <table>
        <h2>Research metadata</h2>
        <tr>
            <td><a href="metadata/addMetaData.jsp">Add researches metadata</a></td>
        </tr>
     </table>
    
    </body>
    
    
</html>
