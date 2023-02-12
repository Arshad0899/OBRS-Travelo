<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.obrs.travels.dto.UserDto"%>
<%@page import="java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OBRS | User Registration</title>

<style type="text/css">
h1 {
	display: flex;
	justify-content: center;
	align-items: center;
}

form {
	width: 500px;
	margin: auto;
	padding: 20px;
}

div {
	margin-bottom: 20px;
}

label {
	display: block;
	font-weight: bold;
	margin-bottom: 10px;
}

input[type="text"], input[type="email"], input[type="password"] {
	padding: 10px;
	font-size: 16px;
	width: 100%;
	box-sizing: border-box;
	border-radius: 10px;
	border-color: none;
	border-style: groove;
}

.button {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 10px 20px;
	background-color: white;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button {
	padding: 10px 20px;
	background-color: #38a53c;
	color: black;
	font-weight: bold;
	border-radius: 20px;
	border-color: black;
	/* border: none; */
	font-size: 15px;
	cursor: pointer;
	margin-right: 10px;
}
</style>

</head>
<body>

	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);
	%>



	<h1>User Registration Form</h1>


	<a href="/travels/admin/user">Go Back</a>
	<br>

	<form action="/travels/admin/user/add" method="POST">
		<div>
			<label for="userName">User Name:</label> <input type="text"
				id="userName" name="UserName">
		</div>
		<div>
			<label for="firstName">First Name:</label> <input type="text"
				id="firstName" name="firstName">
		</div>
		<div>
			<label for="lastName">Last Name: </label> <input type="text"
				id="lastName" name="lastName">
		</div>
		<div>
			<label for="email">Email:</label> <input type="email" id="email"
				name="email">
		</div>
		<div>
			<label for="password">Password:</label> <input type="password"
				id="password" name="password">
		</div>
		<div>
			<label for="phoneNo">Phone No:</label> <input type="text"
				id="phoneNo" name="phoneNo">
		</div>
		<div class="button">
			<input id="submit" type="submit" value="Submit">
		</div>
	</form>
</body>
</html>