<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	margin: 40px;
}

form {
	width: 50%;
	margin: 0 auto;
}

label {
	display: block;
	margin-bottom: 10px;
	font-weight: bold;
}

input[type="text"], input[type="time"], input[type="number"], input[type="date"]
	{
	padding: 10px;
	font-size: 16px;
	width: 100%;
	margin-bottom: 20px;
	box-sizing: border-box;
}

input[type="submit"] {
	
}
</style>

<title>OWNER | REGISTER</title>
</head>
<body>

	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);
	%>

	<h1>Owner Registration Form</h1>
	<form action="/travels/owner/add" method="POST">

		<label for="ownerName">Owner Name:</label> <input type="text" id="ownerName"
			name="ownerName" required>
			<br> <br> 
			
			<label for="username">UserName:</label> <input type="text"
			id="username" name="username" required> 
			
			<br> <br>
		
		<label for="emailId">Email ID:</label> <input type="email"
			id="emailId" name="emailId" required><br> <br> 
			
			<label for="password">password:</label> <input type=password id="password" name="password"
			required>
			
			<br> <br> 
			
			<label for="address">Address: </label> <input type="text" id="address" name="address" required><br>
		<br> 

	 <input type="submit" value="Submit">
	</form>
	
	
</body>

</html>




