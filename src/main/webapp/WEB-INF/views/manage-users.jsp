<%@page import="com.obrs.travels.dto.UserDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin | Users</title>
<style>
th, td {
	padding: 10px 20px;
}
</style>
</head>
<body>


	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	List<UserDto> users = (List<UserDto>) request.getAttribute("usersList");
	%>

	<a href="/travels/admin/">Go Back</a>
	<br>

	<h1>Manage Users</h1>

	<a href="/travels/admin/user/add">Add User</a>

	<br>
	<br>

	<table border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th>ID</th>
				<th>UserName</th>
				<th>First Name</th>
				<th>Phone No</th>
				<th>Email ID</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>


			<%
			for (UserDto user : users) {
			%>
			<tr>
				<td><%=user.getUserId()%></td>
				<td><%=user.getUserName()%></td>
				<td><%=user.getFirstName()%></td>
				<td><%=user.getPhoneNo()%></td>
				<td><%=user.getEmail()%></td>
				<td><a href="/travels/admin/user/update/<%=user.getUserId()%>">
						Update</a></td>
				<td><a href="/travels/admin/user/delete/<%=user.getUserId()%>"
					style="color: red">Remove</a></td>
			</tr>
			<%
			}
			%>



		</tbody>

	</table>



</body>
</html>
