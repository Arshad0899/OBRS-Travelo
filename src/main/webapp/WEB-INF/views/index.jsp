<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" href="css/styles.css">

<style type="text/css">
body {
	margin: 0px;
	background: #FFEFBA; /* fallback for old browsers */
	background: -webkit-linear-gradient(to right, #FFFFFF, #FFEFBA);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to right, #FFFFFF, #FFEFBA);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}

.navigation {
	padding: 0px;
	border: 0px;
}

.navigation h1 {
	display: flex;
	justify-content: center;
	font-size: 45px;
}

.main {
	background-image: url("/WEB-INF/views/Bg.jpg");
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}

.but {
	border-color: #8360c3;
	background-color: #8360c3;
	padding: 5px 8px;
	font-size: 18px;
	border-radius: 10px;
}

.navigation .links {
	display: flex;
	justify-content: center;
	gap: 30px;
}

.navigation .links a:hover {
	color: green;
	/* font-size: 33px; */
	text-decoration-line: underline;
}

.navigation .links a {
	font-size: 20px;
	color: black;
	text-decoration: none;
}

.main {
	display: flex;
	width: 700px;
	height: 500px;
	margin: 60px auto;
	justify-content: center;
	flex-direction: column;
}

.main .text {
	display: flex;
	flex-direction: column;
	font-size: 50px;
	width: 400px;
	height: 200px;
	margin: 0px 0px 0px 300px;
	text-align: end;
	display: flex;
	justify-content: end;
	padding: 0px;
}

.main .text h5 {
	padding: 0px;
	margin: 0px;
	font-size: 30px;
}

.main .searchbox {
	display: flex;
	flex-direction: column;
	width: 500px;
	margin: 30px auto;
	gap: 20px;
	font-size: 20px;
}

input[type="text"] {
	display: block;
	width: calc(100% - 24px);
	font-size: 18px;
	font-weight: 600;
	color: green;
	border-radius: 20px;
	padding: 10px;
	border: 2px solid green;
}

footer {
	width: 400px;
	margin: 0 auto;
}
</style>

</head>
<body>

	<nav class="navigation">
		<h1 class="heading">TRAVELO</h1>
		<div class="links">
			<a href="/travels/user/">User</a> <a href="/travels/admin/login">Admin</a>
			<a href="/travels/owner/login">Owner</a> <a href="/travels/aboutus">About</a>
		</div>
	</nav>

	<main class="main">
		<div class="text">
			<h3>Travel with us safe and reach your destination</h3>
		</div>
	</main>


	<footer>
		<p>© 2023 Copyright: Online Bus Reservation System</p>
	</footer>

</body>
</html>