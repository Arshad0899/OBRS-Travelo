<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">
h1 {
	display: flex;
	justify-content: center;
	align-items: center;
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
<title>OBRS | ADMIN</title>
</head>
<body>

	<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setDateHeader("Expires", -1);

	Boolean tkl = (Boolean) session.getAttribute("tlk");

	if (tkl == true) {

		response.sendRedirect("/travels/admin/no-data");

	}
	%>

	<nav class="navbar navbar-default">
		<!-- Navbar content goes here -->
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="">OBRS</a>
			</div>

			<ul class="nav navbar-nav">
				<li><a href="/travels/admin/home">Home</a></li>
				<li><a href="/travels/admin/bus">Bus</a></li>
				<li><a href="/travels/admin/owner">Owner</a></li>
				<li><a href="/travels/admin/bus/approve">Approve Bus</a>
				<li><a href="/travels/admin/logout">logout</a>
			</ul>
		</div>
	</nav>

	<h1>Welcome, Admin</h1>


</body>
</html>