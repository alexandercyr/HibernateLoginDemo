<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<form action="register" method="Post">
	
		<input type="text" name="firstName" placeholder="first name" required><br>
		<input type="text" name="lastName" placeholder="last name" required><br>
		<input type="text" name="username" placeholder="username" required><br>
		<input type="password" name="password" placeholder="password" required><br>
		<input type="submit" value="Submit">
		
	</form>
</body>
</html>