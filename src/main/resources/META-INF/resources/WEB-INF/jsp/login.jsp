<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form method="post">
		<p>${errorMessage}</p>
		Name : <input type="text" name="name"/>
		Password : <input type="password" name="password"/>
		<button>Submit</button>
	</form>
</body>
</html>