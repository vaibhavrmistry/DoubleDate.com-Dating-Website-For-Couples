<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Profile Page</title>
<!-- BOOTSTRAP STYLES-->
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- FONTAWESOME ICONS STYLES-->
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<!--CUSTOM STYLES-->
<link href="resources//css/search_style.css" rel="stylesheet" />
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=Oleo+Script:400,700'>
<!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<style>
.scrollable {
	height: 500px;
	overflow-y: scroll;
}

li {
	list-style: none
}
</style>


</head>
<body>
	<div id="wrapper">
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="logo col-md-4 ">
						<h1>
							<a href="">CouplesCorner <span class="red">.</span></a>
						</h1>


					</div>
					<div class="links col-md-8 text-right">

						<a href="" class="btn btn-success login-btn" id="logout">Logout</a>
					</div>

				</div>
			</div>
		</div>

		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li>
						<div class="user-img-div">
							<img src='/profileImages/${coupleSU.coupleName}.jpg'
								class="img-circle" onclick="return false"
								onerror="this.src='resources//img/Dashboard/defaultProfile.jpg';" />


						</div>

					</li>
					<li><a href="#"> <strong id="username"> ${coupleSU.coupleName}
						</strong></a></li>

					<li><a href="generalDashboard"> <i class="fa fa fa-user"></i>My
							Profile
					</a></li>
					<li><a href="searchPage"><i class="fa fa-search "></i>Search
					</a></li>

					<li><a class="active-menu" href="findAllChatters"><i
							class="fa fa-envelope "></i>Messages </a></li>


					<li><a href="searchAllAccepted"><i class="fa fa-users "></i>Friends</a>
					</li>

					<li><a href="/"><i class="fa fa-power-off "></i>Logout</a></li>

				</ul>
			</div>

		</nav>
		<!-- /. SIDEBAR MENU (navbar-side) -->
		<div id="page-wrapper" class="page-wrapper-cls">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">My Messages</h1>
					</div>
				</div>
				<div class="col-md-4">
					<div class="panel panel-primary">
						<div class="panel-heading">MESSAGES FROM:</div>
						<div class="panel-body scrollable">
							<ul class="media-list">

								<li class="media">

									<div class="media-body">
										<c:forEach var="users" items="${connectionList}">
											<div class="media">
												<a class="pull-left" href="#"> <img
													class="media-object img-circle" style="max-height: 40px;"
													src='/profileImages/${users}.jpg' onerror="this.src='resources//img/Dashboard/defaultProfile.jpg';" />
												</a>

												<div class="media-body">
													<h5>
														<a class="coupleName">${users}</a>
													</h5>

													<small class="text-muted">Active From 3 hours</small>
												</div>
											</div>
										</c:forEach>
									</div>
								</li>
							</ul>
						</div>
					</div>

				</div>
				<div class="col-md-8">
					<div class="panel panel-info message">
						<div class="panel-heading bg-info">
							Conversation with: <span id="couple-name-msg"></span>
						</div>
						<div class="panel-body scrollable chat-window">
							<ul class="media-list">
							
								<div id="message-body" >
								
								<!-- CHATS DISPLAYED HERE -->
								
								<!--  <li class="media">

									<div class="media-body">

										<div class="media">
											<a class="pull-left" href="#"> <img
												class="media-object img-circle " src="assets/img/user.png" />
											</a>
											<div class="media-body">
												Donec sit amet ligula enim. Duis vel condimentum massa.
												Donec sit amet ligula enim. Duis vel condimentum massa.Donec
												sit amet ligula enim. Duis vel condimentum massa. Donec sit
												amet ligula enim. Duis vel condimentum massa. <br /> <small
													class="text-muted">Alex Deo | 23rd June at 5:00pm</small>
												<hr />
											</div>
										</div>

									</div>
								</li> -->
								
								
								</div>

								
								
							</ul>
						</div>
						<div class="panel-footer">
							<div class="input-group">
								<input type="text" class="form-control chat-input"
									placeholder="Enter Message" /> <span class="input-group-btn">
									<button class="btn btn-info send-button" type="button">SEND</button>
								</span>
							</div>
						</div>
					</div>
				</div>

			</div>

			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>


	<!-- /. WRAPPER  -->

	<footer>
		&copy; 2015 CouplesCorner.com | By : <a
			href="http://www.CouplesCorner.com/" target="_blank">CouplesCorner</a>
	</footer>

	<!-- /. FOOTER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="resources//js/jquery-1.11.1.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="resources//bootstrap/bootstrap.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="resources//js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="resources//js/custom.js"></script>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>


	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>

	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script>
		$(document)
				.ready(
						function() {

							$(".message").hide();

							$(".coupleName").click(function() {
								$(".message").hide();
								var coupleName = $(this).html();
								var userName = $("#username").html();
								$("#couple-name-msg").html(coupleName);
								
								//alert("Username: "+userName +"\nCoupleName: "+coupleName);
								
								$.get("http://localhost:8080/edu/populateMessages",
										{
									chatWith:coupleName
										},
										function(data,status){
											
											
												
													//alert("Message received from controller")
													$("#message-body").html(data);
													
												
										
									
										});
								
								
								
								
								
								
								$(".message").show("slow");

							});

							$(".send-button")
									.click(
											function() {

												var message = $(".chat-input")
														.val();
												var toUser =$("#couple-name-msg").html();
												var userName = $("#username").html();
												var dt = new Date();
												var time = dt.getHours() + ":"
														+ dt.getMinutes() + ":"
														+ dt.getSeconds();

												

												
												
												$.post("http://localhost:8080/edu/addMessages?coupleName="+toUser+"&message="+message,
														function(data,
														status){
													
													//alert("Message Sent to "+toUser);
													
													$(".chat-window")
													.append("<li class='media'><div class='media-body col-md-8 bg-info pull-right'><div class='media'>"+
															"<a class='pull-right'> <img	class='media-object img-circle ' style='max-height: 50px;' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\"  src='/profileImages/"+userName+".jpg' />"
															+"</a> <div class='media-body'>"+message+" <br /> <small class='text-muted'>"+userName+" | "+dt+"</small><hr /></div></div></div></li> ");
													
													
												});

											});

						});
	</script>
</body>
</html>
