<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--This is the login page where system could check if it is a admin or a user.-->
<!--Use admin and admin as username and password in login as admin-->
<!--Use any other string to login as user-->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
 
 <form action="../LoginServlet" method="post">
Username:<input type="text" name="username"/>admin username="admin"<br/>
Password:<input type="password" name="password"/>admin password="admin"<br/>
  <input type="submit" value="Login"/>
 </form>
 
</body>
</html>