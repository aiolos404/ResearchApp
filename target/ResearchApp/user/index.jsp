<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--This is the user index page where user could sign up new account,add new research and search researches-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User interface
</head>
<body>
    <h2>Hi,there</h2>

    <h2>Sign Up</h2>
    <table>
        <tr>
            <td>
   
                 <a href="SignupServlet">Sign Up</a></td> 
        </tr>
    </table>
    <h2>Research</h2>
    <table>
        
        <tr>
            <td><a href="AddResearchServlet">Add Research</a></td>
        </tr>
        <tr>
            <td><a href="research/searchResearch.jsp">Search Research</a></td>
        </tr>
    </table>
    
</body>
</html>