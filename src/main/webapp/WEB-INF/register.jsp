<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register your Account</title>
</head>
<body>

<h3>Register your account by enter username and password</h3>

	<form action="register" method="post">
		<pre>
	    <strong>Register Here | <a href="login">Click here to Login</a></strong>
		
		User Id: <input type="text" name="username" />
		
		Password: <input type="password" name="password" />
	
		<input type="submit" value="Register" />
	</pre>
	</form>
	${msg}
</body>
</html>