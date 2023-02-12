<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.obrs.travels.dto.OwnerDto"%>

<html>
<head>
<style>
.column {
	float: left;
	width: 50%;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

.row {
	display: flex;
}

.column {
	flex: 50%;
}

.column {
	border: 1px solid red;
	height: 600px;
	display: flex;
	flex-direction: column;
	gap: 10px;
	justify-content: center;
	align-items: center;
}

.button-link {
	display: flex;
	align-items: center;
	justify-content: center;
	text-align: center;
	width: 40%;
	color: white;
	background-color: green;
	padding: 10px 20px;
	text-decoration: none;
	border-radius: 5px;
}

.row .column .text-box {
	border: 1px solid red;
	width: 80%;
	height: 400px;
}
</style>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
	
</script>

<style type="text/css">
h2 {
	display: flex;
	align-items: center;
	justify-content: center;;
}
</style>

</head>


<body>

	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	OwnerDto owner = (OwnerDto) session.getAttribute("owner");
	%>

	<nav class="navbar navbar-default">
		<!-- Navbar content goes here -->
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="">OBRS</a>
			</div>

			<ul class="nav navbar-nav">
				<li><a href="/travels/owner/home">Home</a></li>
				<li><a href="/travels/owner/bus/add/<%=owner.getOwnerId()%>">Add
						Bus</a></li>
				<li><a href="/travels/admin/logout">logout</a>
			</ul>
		</div>
	</nav>

	<h2>
		Welcome,
		<%=owner.getOwnerName()%></h2>


</body>
</html>
