<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.obrs.travels.dto.BookingDto"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER | Conformation</title>
<style type="text/css">
table, th, td {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	width: 500px;
}

th, td {
	padding: 10px 20px;
	border: 1px soild black;
	width: 100px;
}

h3 {
	display: flex;
	justify-content: center;
	align-items: : center;
}

.form {
	width: 50%;
	margin: 0px auto;
	display: flex;
	align-items: center;
	justify-content: center;
}

#submit{
display: flex;
justify-content: center;
align-items: center;
}
</style>
</head>
<body>

	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	BookingDto busDetails = (BookingDto) request.getAttribute("booking");
	%>

	<h3>Details</h3>
	<table border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th>Content</th>
				<th>Details</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>UserID</td>
				<td><%=busDetails.getUserId()%></td>
			</tr>

			<tr>
				<td>Passenger name</td>
				<td><%=busDetails.getPassengerName()%></td>
			</tr>
			<tr>
				<td>Phone No</td>
				<td><%=busDetails.getPhoneNo()%></td>
			</tr>
			<tr>
				<td>Bus Name</td>
				<td><%=busDetails.getBusName()%></td>
			</tr>
			<tr>
				<td>bus type</td>
				<td><%=busDetails.getType()%></td>
			</tr>
			<tr>
				<td>Fare</td>
				<td><%=busDetails.getFare()%></td>
			</tr>
			<tr>
				<td>Boarding</td>
				<td><%=busDetails.getBoarding()%></td>
			</tr>
			<tr>
				<td>Destination</td>
				<td><%=busDetails.getDestination()%></td>
			</tr>
			<tr>
				<td>Boarding time</td>
				<td><%=busDetails.getBoardingTime()%></td>
			</tr>
			<tr>
				<td>Arrival time</td>
				<td><%=busDetails.getArrivalTime()%></td>
			</tr>
			<tr>
				<td>Journey Date</td>
				<td><%=busDetails.getJourneyDate()%></td>
			</tr>


		</tbody>
	</table>
	<br><br>

	<form class="form"
		action="/travels/user/reservation/conformation?userId=<%=busDetails.getUserId()%>&busId=<%=busDetails.getBusId()%>&fare=<%=busDetails.getFare()%>"
		method="POST">

		<div>
			 <label for="noOfSeats">No.of seats: </label><input
				type="number" id="noOfSeats" name="noOfSeats" min=1 max=4>
			<input id="submit" type="submit" value="Submit">
		</div>
	</form>

</body>
</html>