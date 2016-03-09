<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<title>Login Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- CSS -->
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet" href="resources//css/style.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

</head>

<body>
	<div class="header">
		<div class="container">
			<div class="row">
				<div class="logo col-md-4">
					<h1>
						<a href="">CouplesCorner <span class="red">.</span></a>
					</h1>

				</div>
				<div class="links col-md-8">

					<a href="#loginmodal" class="btn btn-success login-btn"
						id="modaltrigger">Member Login</a>
				</div>
			</div>
		</div>
		<div class="errorMessage">
			<p>
				<strong>${error}</strong>
			</p>
		</div>
	</div>

	<div class="register-container container">
		<div class="row">

			<div class="register span6">
				<form:form action="register" method="Post"
					commandName="coupleSignUp">
					<img src="resources//img/pattern/pencil.png" alt="pencil"
						class="pencil-image" />

					<h3>
						REGISTER TO <span class="red"><strong>CouplesCorner</strong></span>
					</h3>
					<label for="couplename">Couple Name</label>
					<div class="row">
						<form:input path="coupleName" id="couplename" name="coupleName"
							placeholder="enter your unique couple name..."
							required="required" />
					</div>
					<div class="row unique-couple-name"></div>
					<div class="row couple-validation"></div>
					<div class="row">
						<label for="email">Email-Id</label>
						<form:input path="emailId" type="email" id="email" name="emailId"
							placeholder="enter your email..." required="required" />
					</div>
					<div class="row email-validation"></div>
					<div class="row">
						<label for="password">Password</label>
						<form:input path="password" type="password" id="register-password"
							name="password" placeholder="choose a password..."
							required="required" />
					</div>
					<div class="row password-validation"></div>
					<div class="row">

						<label for="password">Confirm Password</label> <input
							type="password" id="re-password" name="re-password"
							placeholder="retype the password..." required="required" />
					</div>
					<div class="row re-password"></div>
					<div class="row">
						<button type="submit">REGISTER</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>

	<div id="loginmodal" style="display: none;">
		<div class="text-center">
			<div class="row">
				<h1>Member Login</h1>
			</div>
			<form:form id="loginform" commandName="coupleSignUp" name="loginform"
				method="Post" action="login" onsubmit="">
				<div class="row">
					<label for="coupleName">Couple Name:</label>
				</div>
				<div class="row">
					<form:input path="coupleName" type="coupleName" name="coupleName"
						id="coupleName" class="txtfield" tabindex="1" required="required" />
				</div>
				<div class="row couple-name-error">
					<form:errors path="coupleName" style="color:#428bca"></form:errors>
				</div>

				<div class="row">
					<label for="password">Password:</label>
				</div>
				<div class="row">
					<form:input path="password" type="password" name="password"
						id="password" class="txtfield" tabindex="2" required="required" />
				</div>
				<div class="row password-error">
					<form:errors path="password" style="color:#428bca"></form:errors>
				</div>
				<div class="row">
					<form:checkbox name="remember" path="remember" value="Yes"/>
					Remember Me
				</div>
				<div class="row">
					<div class="center">
						<input type="submit" name="loginbtn" id="loginbtn"
							class="flatbtn-blu hidemodal" value="Log In" tabindex="3" />
					</div>
				</div>
			</form:form>
		</div>
	</div>

	<!-- Javascript -->
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="resources//js/jquery.leanModal.min.js"></script>
	<!--<script src="resources//bootstrap/bootstrap.min.js"></script>-->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-backstretch/2.0.4/jquery.backstretch.min.js"></script>
	<script src="resources//js/scripts.js"></script>

</body>

</html>

