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
<title>Admin | Bus</title>
<link rel="stylesheet" href=
"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
    <script src=
"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
    <script src=
"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
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
	border: 1px soild blacck;
}

h3{
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

	List<BusDto> buses = (List<BusDto>) request.getAttribute("BusList");
	%>

	<nav class="navbar navbar-default">
		<!-- Navbar content goes here -->
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="">OBRS</a>
			</div>

			<ul class="nav navbar-nav">
				<li><a href="/travels/admin/">Home</a></li>
				<li><a href="/travels/admin/bus">Bus</a></li>
				<li><a href="/travels/admin/owner">Owner</a></li>
				<li><a href="/travels/admin/bus/approve">Approve Bus</a>
				<li><a href="/travels/admin/logout">logout</a>
			</ul>
		</div>
	</nav>
	

	<h3>Manage Bus</h3>

	<br>
	<br>

	<table border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th>ID</th>
				<th>Bus name</th>
				<th>Driver</th>
				<!-- 		<th>Reg.No</th>  -->
				<th>Type</th>
				<th>Boarding</th>
				<th>Destination</th>
				<th>Start Time</th>
				<th>End Time</th>
				<th>Fare</th>
				<!--	    <th>Available Seats</th> -->
				<th>Journey date</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>


			<%
			for (BusDto bus : buses) {
			%>
			<tr>
				<td><%=bus.getBus_id()%></td>
				<td><%=bus.getBusname()%></td>
				<td><%=bus.getDriverName()%></td>
				<!--  		<td><%=bus.getRegNo()%></td>  -->
				<td><%=bus.getType()%></td>
				<td><%=bus.getBoarding()%></td>
				<td><%=bus.getDestination()%></td>
				<td><%=bus.getStartTime()%></td>
				<td><%=bus.getEndTime()%></td>
				<td><%=bus.getFare()%></td>
				<!--    <td><%=bus.getAvailableSeats()%></td>   -->
				<td><%=bus.getJourneyDate()%></td>
				<td style="color: red;"><a
					href="/travels/admin/bus/delete/<%=bus.getBus_id()%>"
					style="color: red">Remove</a></td>
			</tr>
			<%
			}
			%>



		</tbody>

	</table>



</body>
</html>