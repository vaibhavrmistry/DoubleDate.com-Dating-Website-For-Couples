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

					<li><a href="generalDashboard"> <i class="fa fa fa-user"></i>My
							Profile
					</a></li>
					<li><a href="searchPage"><i class="fa fa-search "></i>Search
					</a></li>

					<li><a href="findAllChatters"><i class="fa fa-envelope "></i>Messages
					</a></li>


					<li><a class="active-menu" href="searchAllAccepted"><i
							class="fa fa-users "></i>Friends</a></li>

					<li><a href="logout"><i class="fa fa-power-off "></i>Logout</a>
					</li>

				</ul>
			</div>

		</nav>
		<!-- /. SIDEBAR MENU (navbar-side) -->
		<div id="page-wrapper" class="page-wrapper-cls">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">My Friends</h1>
					</div>
				</div>

				<div class="row">
					<div class="col-md-10">
						<div class="panel-body">
							<ul class="nav nav-tabs nav-justified ">
								<li class="active "><a href="#friendList" data-toggle="tab" id = "friend-all-page"><strong
										class="text-primary">Friends</strong> <span class="badge"></span></a>
								</li>
								<li class=""><a href="#friendRequest" data-toggle="tab" id="friend-request-page"><strong
										class="text-primary">Friend Requests</strong> <span
										class="badge"></span></a></li>
								<li class=""><a href="#pendingRequest" data-toggle="tab" id="friend-pending-page"><strong
										class="text-primary" >Pending Friend Requests</strong> <span
										class="badge"></span></a>
							</ul>

							<div class="tab-content">
								<div class="tab-pane fade active in" id="friendList">
									<div class="row search-friends">
										
									</div>
									<div class="col-md-12 ">
										<ul class="thumbnails">

											<div class="display-friend-list">
												<!-- Search Results displayed here -->
												<c:forEach var="coupleName" items = "${acceptedFriends}">
													<li class=" clearfix">
														<div class="thumbnail clearfix">
															<img src="/profileImages/${coupleName.coupleName}.jpg" alt='ALT NAME' class='pull-left  img-circle' onerror="this.src='resources//img/Dashboard/defaultProfile.jpg';" style='margin-right: 10px; width: 150px; height: 150px;'>
															<div class="caption">
																<a 
																	class="btn btn-danger icon  pull-right unfriend-btn">Unfriend</a> 
																	<form action="profileViewFriend" method="get">
																	<input type="hidden" name="viewCoupleName" value="${coupleName.coupleName}"/>
																	<button type="submit"			
																	class="btn btn-primary icon  pull-right view-friend-profile">View
																	Profile</button>
																	</form>

																<h4>

																	<a href="#">${coupleName.coupleName}</a>
																</h4>
																<small><b>Couple Info: </b><span
																	class="coupleName couple-info"> <span
																		class="person1-age">${coupleName.getCoupleInfo().getPersonList().get(0).getAge()}</span> years old <span
																		class="person1-sex"> ${coupleName.getCoupleInfo().getPersonList().get(0).getSex()}</span> <span class="&">
																			& </span> <span class="person2-age">${coupleName.getCoupleInfo().getPersonList().get(1).getAge()}</span> years old
																		<span class="person2-sex">${coupleName.getCoupleInfo().getPersonList().get(1).getSex()}</span>
																</span> <br /> <span class="coupleName location"><strong>Current
																			Location:</strong><span class="coupleName location">
																			Boston</span><br /> <b>What are we looking for: </b><span
																		class="username story">${coupleName.getCoupleInfo().lookingfor}</span></small>
															</div>
														</div>
													</li>
												</c:forEach>
											</div>
										</ul>
									</div>


								</div>
								<div class="tab-pane fade" id="friendRequest">
									<div class="row">
										<div class="search-friends">
											<ul class="thumbnails">

												<div class="display-friend-request">
													<!-- Search Results displayed here -->
													
													
													
												</div>

											</ul>

										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="pendingRequest">
									<div class="row">
										<div class="search-friends">
											<ul class="thumbnails">
												<div class="display-pending-request">
													<!-- Search Results displayed here -->
													

												</div>

											</ul>

										</div>
									</div>
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
			&copy; 2015 doubleDate.com | By : <a
				href="http://www.doubleDate.com/" target="_blank">doubleDate</a>
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
			$(document).ready(function() {
				
				
				//-------Call AJAX for displaying all friends
				$("#friend-all-page").click(function(){
					
					//alert("clicked");
					
					
					    location.reload();
						
					
					}); 
				
				
				
				
				//-------Call AJAX for Friend Requests Pending reveived
				
				$("#friend-request-page").click(function(){
					
					//alert("clicked");
					
					$.get("http://localhost:8080/edu/pendingReceivedByUser",
							function(data, status){
						
						if(status == "success")
							{
							$(".display-friend-request").html(data);
							
							$(".accept-btn").bind("click",	addFriend);
							$(".decline-btn").bind("click",	declineRequest);
							$("#friend-request-page").next().html($(".request-count"));
							}
						
						
					});
					
					
					
				});
				
				//-------Call AJAX for Pending Friend Requests pending sent by user
				
$("#friend-pending-page").click(function(){
					
					//alert("clicked");
					
					$.get("http://localhost:8080/edu/pendingSendByUser",
							function(data, status){
						
						if(status == "success")
							{
							$(".display-pending-request").html(data);
							$("#friend-pending-page").next().html($(".pending-count"));
							}
						
						
					});
					
					
					
				});
				
//-------Call AJAX for Accepting Friend Requests
				function addFriend(){
					
					var button = $(this);
					var coupleToAccept = button.next().children().html();
					
					//alert("Couple to accept: "+coupleToAccept );
					
					$.get("http://localhost:8080/edu/acceptingPendingRequest",
									{
						coupleToAccept:coupleToAccept
									},
									function(data, status){
										alert("Call received from controller")
										if(data == "success")
											{
												button.parent().parent().parent().hide();
											
											}
									}
					
					
					
					)
					
					
					
					
					
					
				};
				
				//-------Call AJAX for Declining Friend Requests
				
				function declineRequest(){
					
					
					var button = $(this);
					var coupleToDecline = button.next().next().children().html();
					
					//alert("Couple to decline: "+coupleToDecline );
					
					$.get("http://localhost:8080/edu/decliningPendingRequest",
									{
						coupleToDecline:coupleToDecline
									},
									function(data, status){
										alert("Call received from controller")
										if(data == "success")
											{
												button.parent().parent().parent().hide();
											
											}
									}
					
					
					
					)
					
					
					
				};
				
				
				
				
				//-------Call AJAX for Viewing Friend's Profile
				
				
				
				$(".view-friend-profile").click(function(){
					
					var button = $(this);
					var friendName = button.next().children().html();
					
					//alert ("Friend Name:"+ friendName);
					
					$.get("http://localhost:8080/edu/profileViewFriend",
							{
				viewCoupleName:friendName
							},
							function(data, status){
								//alert("Call received from controller")
								if(data == "success")
									{
										button.parent().parent().parent().hide();
									
									}
							}
			
			
			
			)

					
					
					
					
				});
				
				
				
				
				//----------AJAX call for Unfriend--------
				
				$(".unfriend-btn").click(function(){
					
					var button = $(this);
					var coupleName = button.next().next().children().html();
					
					//alert("Couple Selected: "+coupleName)
					
					$.get("http://localhost:8080/edu/unfriend",
							{
						coupleToUnfriend:coupleName
							},
							function(data, status){
								alert("Call received from controller")
								if(data == "success")
									{
										button.parent().parent().parent().hide();
									
									}
							
							});
					
					
					
					
					
				});
				
				
				
				
				
								

								
								

								

							});
		</script>
</body>
</html>
