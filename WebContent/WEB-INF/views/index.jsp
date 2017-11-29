<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
	<h1>Login!</h1>
	<form action="login" method="Post">
		<input type="text" name="username" placeholder="username" required>
		<input type="password" name="password" placeholder="password" required>
		<input type="submit" value="Login">
	</form>
	<a href="addNewUser">Register</a>
	${ alert }
</body>
</html>