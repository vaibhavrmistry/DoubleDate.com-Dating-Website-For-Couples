<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

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
<link href="resources//css/Dashboardstyle.css" rel="stylesheet" />
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
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a  class="navbar-brand" href="index.html">DoubleDate.

                </a>
            </div>

           </nav>


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
					<li><a href="#"> <strong> ${coupleSU.coupleName}
						</strong></a></li>

					<li><a href="generalDashboard"> <i class="fa fa fa-user"></i>Profile
					</a></li>
					<li><a href="searchPage"><i class="fa fa-search "></i>Search
					</a></li>

					<li><a href="findAllChatters"><i class="fa fa-envelope "></i>Messages
					</a></li>


					<li><a class="active-menu" href="searchAllAccepted"><i
							class="fa fa-users "></i>Friends</a></li>

					<li><a href="logout"><i class="fa fa-power-off "></i>Logout</a></li>

				</ul>
			</div>

		</nav>
		<!-- /. SIDEBAR MENU (navbar-side) -->
		<div id="page-wrapper" class="page-wrapper-cls">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">${viewCoupleName.coupleName}
							Profile</h1>
					</div>
				</div>

				<div id="profile-info" class="container target">
					<div class="row">
						<div class="col-sm-10">
							<h1 class="couple-name"></h1>

							
							<button type="button" class="btn btn-success" id="send-message"
								id="send-message" data-toggle="modal" data-target="#myModal">Send
								Message</button>
							<br>
						</div>

						<div class="col-sm-2">
							<a href="/users" class="pull-right"><img
								src='/profileImages/${viewCoupleName.coupleName}.jpg'
								class="img-circle" onclick="return false"
								onerror="this.src='resources//img/Dashboard/defaultProfile.jpg';" />
							</a>

						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-3">
							<!--left col-->
							<ul class="list-group">
								<li class="list-group-item text-muted" contenteditable="false">Person
									1 Info</li>
								<li class="list-group-item text-right fname1 "><span
									class="pull-left"><strong class="">First Name</strong></span><span
									class="fname1">${viewCoupleInfo.getPersonList().get(0).firstName}</span></li>
								<li class="list-group-item text-right lname1 "><span
									class="pull-left"><strong class="">Last Name</strong></span><span
									class="lname1">${viewCoupleInfo.getPersonList().get(0).lastName}</span></li>
								<li class="list-group-item text-right age"><span
									class="pull-left"><strong class="">Age</strong></span><span
									class="p1-age">${viewCoupleInfo.getPersonList().get(0).age}</span></li>
								<li class="list-group-item text-right sex "><span
									class="pull-left"><strong class="">Sex</strong></span><span
									class="p1-age">${viewCoupleInfo.getPersonList().get(0).sex}</span></li>
								<li class="list-group-item text-right hometown"><span
									class="pull-left"><strong class="">Hometown</strong></span><span
									class="p1-hometown">${viewCoupleInfo.getPersonList().get(0).hometown}</span></li>
								<li class="list-group-item text-right occupation"><span
									class="pull-left"><strong class="">Occupation</strong></span><span
									class="p1-occupation">${viewCoupleInfo.getPersonList().get(0).occupation}</span></li>
								<li class="list-group-item text-right phone"><span
									class="pull-left"><strong class="">Phone</strong></span><span
									class="p1-hometown">${viewCoupleInfo.getPersonList().get(1).phone}</span></li>
								<li class="list-group-item text-right email"><span
									class="pull-left"><strong class="">Email</strong></span><span
									class="p1-occupation">${viewCoupleInfo.getPersonList().get(1).emailId}</span></li>


							</ul>
							<ul class="list-group">
								<li class="list-group-item text-muted" contenteditable="false">Person
									2 Info</li>
								<li class="list-group-item text-right fname2 "><span
									class="pull-left"><strong class="">First Name</strong></span><span
									class="fname2">${viewCoupleInfo.getPersonList().get(1).firstName}</span></li>
								<li class="list-group-item text-right lname2 "><span
									class="pull-left"><strong class="">Last Name</strong></span><span
									class="lname2">${viewCoupleInfo.getPersonList().get(1).lastName}</span></li>
								<li class="list-group-item text-right age"><span
									class="pull-left"><strong class="">Age</strong></span><span
									class="p2-age">${viewCoupleInfo.getPersonList().get(1).age}</span></li>
								<li class="list-group-item text-right hometown"><span
									class="pull-left"><strong class="">Hometown</strong></span><span
									class="p2-hometown">${viewCoupleInfo.getPersonList().get(1).hometown}</span></li>
								<li class="list-group-item text-right occupation"><span
									class="pull-left"><strong class="">Occupation</strong></span><span
									class="p2-occupation">${viewCoupleInfo.getPersonList().get(1).occupation}</span></li>
								<li class="list-group-item text-right phone"><span
									class="pull-left"><strong class="">Phone</strong></span><span
									class="p1-hometown">${viewCoupleInfo.getPersonList().get(1).phone}</span></li>
								<li class="list-group-item text-right email"><span
									class="pull-left"><strong class="">Email</strong></span><span
									class="p1-occupation">${viewCoupleInfo.getPersonList().get(1).emailId}</span></li>


							</ul>
							<div class="panel panel-default">
								<div class="panel-heading">Current Location</div>
								<div class="panel-body">
									<i class="fa fa-map-marker curr-location"></i><span
										class="curr-location">${viewCoupleInfo.location}</span>

								</div>
							</div>

						</div>
						<!--/col-3-->
						<div class="col-sm-9" contenteditable="false" style="">
							<div class="panel panel-default">
								<div class="panel-heading">Our Story</div>
								<div class="panel-body story">${viewCoupleInfo.story}</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">Activities we like</div>
								<c:forEach var="activity" items="${activityList}">
									<div class="panel-body activities">${activity.activityName}
									</div>
								</c:forEach>
							</div>
							<div class="panel panel-default target">
								<div class="panel-heading" contenteditable="false">Our
									Favourites</div>
								<div class="panel-body">
									<div class="row">
										<div class="col-md-6">
											<div class="thumbnail">
												<img alt="300x200" src="http://lorempixel.com/300/100/food">
												<div class="caption">
													<h3>Restaurants</h3>
													<p class="restaurant">${viewCoupleInfo.restaurants}</p>
													<p></p>
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<div class="thumbnail">
												<img alt="300x200"
													src="http://lorempixel.com/300/100/abstract">
												<div class="caption">
													<h3>Music Artists</h3>
													<p class="artist">${viewCoupleInfo.musicArtists}</p>
													<p></p>
												</div>
											</div>
										</div>


									</div>

								</div>

							</div>
							<div class="panel panel-default">
								<div class="panel-heading">What are we looking for</div>
								<div class="panel-body looking-for">${viewCoupleInfo.lookingfor}</div>
							</div>
						</div>


						<div id="push"></div>
					</div>


					<!-- <script src="/plugins/bootstrap-select.min.js"></script>
        <script src="/codemirror/jquery.codemirror.js"></script>
        <script src="/beautifier.js"></script>-->


				</div>


			</div>
		</div>

	</div>



	<div id="push"></div>
	</div>

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close bg-danger" data-dismiss="modal"
						aria-hidden="true">X</button>
					<h4 class="modal-title">New Message</h4>
				</div>
				<div class="modal-body">
					<form role="form" class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2" for="inputTo">To</label>
							<div class="col-sm-10">
								<input class="form-control" id="inputTo"
									placeholder="List of recipients" type="email"
									value="${viewCoupleName.coupleName}" disabled>
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-12" for="inputBody">Message</label>
							<div class="col-sm-12">
								<textarea class="form-control" id="inputBody" rows="8"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal">Cancel</button>

					<button type="button" class="btn btn-primary " id="sendMessage">
						Send <i class="fa fa-arrow-circle-right fa-lg"></i>
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>


	<!--   <script src="/plugins/bootstrap-select.min.js"></script>
        <script src="/codemirror/jquery.codemirror.js"></script>
        <script src="/beautifier.js"></script>-->


	</div>

	<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
	</div>
	</div>
	<!-- /. WRAPPER  -->
	<footer>
		&copy; 2015 DoubleDate.com | By : <a href="http://www.DoubleDate.com/"
			target="_blank">DoubleDate</a>
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
	<script>

	$(document).ready(function(){
		
	
		//--------AJAX code for Sending Message-----
		
		$("#sendMessage").click(function(){
			
			var coupleTo = $("#inputTo").val();
			var messageBody = $("#inputBody").val();
			
			
			$.post("http://localhost:8080/edu/addMessages?coupleName="+coupleTo+"&message="+messageBody,
					function(data,
					status){
				
				alert("Message Sent to "+coupleTo);
				
				$("#myModal").hide("slow");
				
				
			});
			
			
			
			
		});
	
	
	
	
	
	
	});
	
	
	





</script>
</body>
</html>
