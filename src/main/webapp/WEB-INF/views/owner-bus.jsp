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
<title>Owner | Bus</title>
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
</style>
</head>
<body>

	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	List<BusDto> buses = (List<BusDto>) request.getAttribute("BusList");
	%>

	<a href="/travels/owner/">Go Back</a>
	<br>
	<h1>Manage your Bus</h1>

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
				<th>Update</th>
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