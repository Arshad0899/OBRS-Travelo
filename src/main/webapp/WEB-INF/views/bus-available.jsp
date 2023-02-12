<%@page import="com.obrs.travels.dto.BusDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>USER | Bus BOOKING</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
</script>
<style>
table, th, td{
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

h1{
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

	Boolean tkl = (Boolean) session.getAttribute("token");

	
	if (tkl == true) {

		response.sendRedirect("/travels/user/no-bus-available");

	}

	List<BusDto> buses = (List<BusDto>) request.getAttribute("busList");
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
	<br>
	
	<!-- <h3>hi, ${userId}</h3> -->
	 
	<h1>Buses Available</h1>

	<table border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th>ID</th>
				<th>Bus name</th>
				<th>Type</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Seats available</th>
				<th>Fare</th>
				<th>Journey date</th>
				<th>Book</th>
			</tr>
		</thead>

		<%
		for (BusDto bus : buses) {
		%>
			<tbody>
				<tr>
					<td><%=bus.getBus_id()%></td>
					<td><%=bus.getBusname()%></td>
					<td><%=bus.getType()%></td>
					<td><%=bus.getStartTime()%></td>
					<td><%=bus.getEndTime()%></td>
					<td><%=bus.getAvailableSeats()%></td>
					<td>₹ <%=bus.getFare()%></td>
					<td><%=bus.getJourneyDate()%></td>
					<td><a href="/travels/user/reservation/book?busId=<%=bus.getBus_id()%>&userId=${userId}">Book</a></td>
				</tr>
			</tbody>
		<%}%>

	</table>

</body>
</html>