<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.obrs.travels.dto.BusDto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN | BUS UPDATE</title>
<style>
<
style type ="text /css ">h1 {
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

	BusDto bus = (BusDto) request.getAttribute("bus");
	%>

	<a href="/travels/admin/bus">Go Back</a>
	<br>

	<h1>Update Bus</h1>

	<form action="/travels/admin/bus/update" method="POST">
		<div>
			<label for="busname">Bus Name:</label> <input type="text"
				id="busname" name=busname value="<%=bus.getBusname()%>">
		</div>
		<div>
			<label for="driverName">Driver Name:</label> <input type="text"
				id="driverName" name="driverName" value="<%=bus.getDriverName()%>">
		</div>
		<div>
			<label for="regNo">Reg.No: </label> <input type="text" id="regNo"
				name="regNo" value="<%=bus.getDriverName()%>">
		</div>
		<div>
			<label for="type">Type:</label> <input type="text" id="type"
				name="type" value="<%=bus.getDriverName()%>">
		</div>
		<div>
			<label for="boarding">Boarding:</label> <input type="text"
				id="boarding" name="boarding" value="<%=bus.getDriverName()%>">
		</div>
		<div>
			<label for="destination">Destination:</label> <input type="text"
				id="destination" name="destination" value="<%=bus.getDriverName()%>">
		</div>
		<div>
			<label for="startTime">Start Time:</label> <input type="time"
				id="startTime" name="startTime" value="<%=bus.getDriverName()%>">
		</div>
		<div>
			<label for="endTime">End Time:</label> <input type="time"
				id="endTime" name="endTime">
		</div>
		<div>
			<label for="fare">Fare:</label> <input type="text" id="fare"
				name="fare">
		</div>
		<div>
			<label for="noOfSeats">Total Seats:</label> <input type="number"
				id="noOfSeats" name="noOfSeats">
		</div>
		<div>
			<label for="seatsBooked">Seats Booked:</label> <input type="number"
				id="seatsBooked" name="seatsBooked">
		</div>
		<div>
			<label for="availableSeats">Available Seats:</label> <input
				type="number" id="availableSeats" name="availableSeats">
		</div>
		<div>
			<label for="journeyDate">Journey Date:</label> <input type="date"
				id="journeyDate" name="journeyDate">
		</div>
		<div class="button">
			<input id="submit" type="submit" value="Submit">
		</div>

	</form>


</body>
</html>