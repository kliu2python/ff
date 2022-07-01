<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter your username and password to login</title>
</head>
<body>
	<h3>Enter your username and password to login</h3>
		<form action="login" method="post">
		<pre>
		<strong>Login Here | <a href="register">Click here to Register</a></strong>
		
		User Id: <input type="text" name="username" />
	
		Password: <input type="password" name="password" />

		<input type="submit" value="Login" />
		</pre>
	</form>
	${msg}
</body>
</html>