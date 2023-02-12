<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous" />
<link rel="stylesheet" href="Style.css" />
<title>Document</title>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;900&display=swap')
	;

*, body {
	font-family: 'Poppins', sans-serif;
	font-weight: 400;
	-webkit-font-smoothing: antialiased;
	text-rendering: optimizeLegibility;
	-moz-osx-font-smoothing: grayscale;
}

html, body {
	height: 100%;
	background-color: white;
	color: black;
}

.form-holder {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	text-align: center;
	min-height: 100vh;
}

.form-holder .form-content {
	position: relative;
	text-align: center;
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	-webkit-justify-content: center;
	justify-content: center;
	-webkit-align-items: center;
	align-items: center;
	padding: 60px;
}

.form-content .form-items {
	border: 3px solid black;
	padding: 40px;
	display: inline-block;
	width: 100%;
	min-width: 540px;
	-webkit-border-radius: 10px;
	-moz-border-radius: 10px;
	border-radius: 10px;
	text-align: left;
	-webkit-transition: all 0.4s ease;
	transition: all 0.4s ease;
}

.form-content h3 {
	color: black;
	/*   border:1px solid black; */
	text-align: left;
	font-size: 28px;
	font-weight: 600;
	margin-bottom: 5px;
}

.form-content h3.form-title {
	margin-bottom: 30px;
}

.form-content p {
	color: black;
	text-align: left;
	font-size: 17px;
	font-weight: 300;
	line-height: 20px;
	margin-bottom: 30px;
}

.form-content label, .was-validated .form-check-input:invalid ~.form-check-label,
	.was-validated .form-check-input:valid ~.form-check-label {
	color: black;
	padding: 10px;
}

.btn-primary {
	background-color: #6C757D;
	outline: none;
	border: 0px;
	box-shadow: none;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active {
	background-color: #495056;
	outline: none !important;
	border: none !important;
	box-shadow: none;
}

.form-content textarea {
	position: static !important;
	width: 100%;
	padding: 8px 20px;
	border-radius: 6px;
	text-align: left;
	background-color: #fff;
	border: 0;
	font-size: 15px;
	font-weight: 300;
	color: #8D8D8D;
	outline: none;
	resize: none;
	height: 120px;
	-webkit-transition: none;
	transition: none;
	margin-bottom: 14px;
	border: 0.1px solid #8D8D8D;
}

.form-content textarea:hover, .form-content textarea:focus {
	border: 0;
	background-color: #ebeff8;
	color: #8D8D8D;
}

.mv-up {
	margin-top: -9px !important;
	margin-bottom: 8px !important;
}

.invalid-feedback {
	color: #ff606e;
}

.valid-feedback {
	color: #2acc80;
}
</style>

</head>
<body>
	<div class="form-body">
		<div class="row">
			<div class="form-holder">
				<div class="form-content">
					<div class="form-items">
						<h3>Owner Reservation Form</h3>
						<form action="/travels/owner/signup" method="POST" class="requires-validation" novalidate>
							<div class="col-md-12">
								<label for="ownerName">Owner Name</label> <input
									class="form-control" type="text" placeholder="owner Name"
									id="ownerName" name="ownerName" required />
							</div>
							<div class="col-md-12">
								<label for="username">User Name</label> <input
									class="form-control" type="text" placeholder="userName"
									id="username" name="username" required />
							</div>
							<div class="col-md-12">
								<label for="emailId">Email</label> <input class="form-control"
									type="email" placeholder="email" id="emailId" name="emailId" required />
							</div>
							<div class="col-md-12">
								<label for="password">Password</label> <input
									class="form-control" type="password" placeholder="Password"
									id="password" name="password" required />
							</div>
							<div class="col-md-12">
								<label for="address">Address</label>
								<textarea class="form-control" type="address"
									placeholder="address" id="address" name="address" required></textarea>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="invalidCheck" required /> <label class="form-check-label">I
									confirm that all data are correct</label>
							</div>
							<div class="form-button mt-3">
								<button id="submit" type="submit" class="btn btn-primary">
									Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		(function() {
			"use strict";
			const forms = document.querySelectorAll(".requires-validation");
			Array.from(forms).forEach(function(form) {
				form.addEventListener("submit", function(event) {
					if (!form.checkValidity()) {
						event.preventDefault();
						event.stopPropagation();
					}

					form.classList.add("was-validated");
				}, false);
			});
		})();
	</script>
</body>
</html>
