<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="com.obrs.travels.dto.PaymentProcessDto"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER | PAYMENT</title>

<style type="text/css">
h3 {
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

input[type="text"], input[type="email"], input[type="password"], #cardNo {
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

	PaymentProcessDto process = (PaymentProcessDto) request.getAttribute("procee");
	%>

	<h3>Payment:</h3>

	<form action="/travels/user/booking/payment/" method="post">
		<label for="cardNo">Card Number:</label> <input type = "text" inputmode="numeric"
			id="cardNo" name="cardNo" required> <br>
		<br> <label for="email">Email:</label> <input type="email"
			id="email" name="email" required> <br>
		<br> <label for="expireDate">Expiration Date:</label> <input
			type="text" id="expireDate" name="expireDate" required>
		<br>
		<br> <label for="nameOncard">Name on Card:</label> <input
			type="text" id="nameOncard" name="nameOncard" required> <br>
		<br> <label for="totalPrice">Total Price:</label> <input
			type="text" id="totalPrice" name="totalPrice" value="<%=process.getAmount()%>" 
		readonly="readonly"	required> <br>
		<br> <input type="submit" value="Check Out">
	</form>


</body>
</html>