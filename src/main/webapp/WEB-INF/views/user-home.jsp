<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.obrs.travels.dto.UserDto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>OBRS | USER HOME</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
</script>
<style type="text/css">
form {
	width: 500px;
	margin: 0 auto;
	text-align: left;
	padding: 20px;
}

label {
	font-weight: bold;
	margin-top: 20px;
	display: block;
}

input[type="text"], input[type="date"] {
	padding: 10px;
	width: 100%;
	margin-top: 20px;
	font-size: 16px;
	border-radius: 5px;
	border: 1px solid #ccc;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-top: 20px;
	background-color: #4CAF50;
	color: white;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}
h3{
display: flex;
justify-content: center;
align-items: center;

}

input[type="submit"]:hover {
	background-color: #3e8e41;
}
</style>
</head>
<body>

	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	UserDto userDto = (UserDto) session.getAttribute("user");

	if (userDto == null) {

		response.sendRedirect("travels/");

	}

	// UserDto user = (UserDto) request.getAttribute("user");
	%>
	
	<nav class="navbar navbar-default">
		<!-- Navbar content goes here -->
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="">OBRS</a>
			</div>

			<ul class="nav navbar-nav">
				<li><a href="/travels/user/home">Home</a></li>
				<li><a href="/travels/user/logout">logout</a>
			</ul>
		</div>
	</nav>

	<h3>Welcome back, <%=userDto.getUserName()%></h3>
	<form action="/travels/user/bus-available?userId=<%=userDto.getUserId()%>" method="POST">
		<label for="boarding">Boarding Point:</label> <input type="text"
			id="boarding" name="boarding"> <label for="destination">Destination:</label>
		<input type="text" id="destination" name="destination"> <label
			for="journeyDate">Date:</label> <input type="date" id="journeyDate"
			name="journeyDate"> <input type="submit" value="Submit">
	</form>




</body>
</html>