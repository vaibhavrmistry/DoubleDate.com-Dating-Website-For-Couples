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
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="logo col-md-4 ">
						<h1>
							<a href="">DoubleDate <span class="red">.</span></a>
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
					<li><a href="#"> <strong> ${coupleSU.coupleName}
						</strong></a></li>

					<li><a href="Dashboard"> <i class="fa fa fa-user"></i>My
							Profile
					</a></li>
					<li><a class="active-menu" href="searchPage"><i
							class="fa fa-search "></i>Search </a></li>

					<li><a href="findAllChatters"><i class="fa fa-envelope "></i>Messages
					</a></li>


					<li><a href="searchAllAccepted"><i class="fa fa-users "></i>Friends</a>
					</li>

					<li><a href="blank.html"><i class="fa fa-power-off "></i>Logout</a>
					</li>

				</ul>
			</div>

		</nav>
		<!-- /. SIDEBAR MENU (navbar-side) -->
		<div id="page-wrapper" class="page-wrapper-cls">
			<div id="page-inner">
				<div class="row">

					<div class="col-md-12">
						<h1 class="page-head-line">Search Couples</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">

						<h3>Search couples in your location:</h3>
						<div id="custom-search-input">
							<div class="input-group col-md-12">
								<input type="text" class="form-control input-lg"
									placeholder="Eg: Boston" id="searchLocation" /> <span
									class="input-group-btn">
									<button class="btn btn-info btn-lg" type="button"
										id="searchLocationButton">
										<i class="glyphicon glyphicon-search"></i>
									</button>

								</span>
							</div>
						</div>
					</div>
					<div class="col-md-2 text-center">
						<h3>OR</h3>
					</div>
					<div class="col-md-6">

						<h3>
							Search couples From: <input type="number" min="18" max="80"
								step="1" id="minAgeText" /> to <input type="number" min="18"
								max="80" step="1" id="maxAgeText">
							<button class="btn btn-info btn-lg" type="button"
								id="searchByAgeButton">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</h3>
					</div>

				</div>
				<br>

				<div class="row">

					<div id="filter-panel" class="collapse filter-panel col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<form class="form-inline" role="form">
									<!-- form group [rows] -->
									<div class="row">
										<div class="col-md-6">
											<div class="form-group">
												<label class="filter-col" style="margin-right: 0;"
													for="pref-search">Search by Couple Name:</label> <input
													type="text" class="form-control input-sm"
													id="coupleNameSearchText">
												<button type="button" class="btn btn-default filter-col"
													id="coupleNameSearchButton">
													<span class="glyphicon glyphicon-search"></span> Search
												</button>
											</div>




										</div>

										<div class=" text-left col-md-1">
											<h4>OR</h4>
										</div>

										<!-- form group [order by] -->
										<div class="col-md-4">
											Activity: <select id="activity" class="form-control">
												<c:forEach var="activity" items="${activityAll}">
													<option>${activity.activityName}</option>
												</c:forEach>
											</select>
											<button type="button" class="btn btn-default filter-col"
												id="activitySearchButton">
												<span class="glyphicon glyphicon-search"></span> Search
											</button>

										</div>

									</div>
							</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-12">
					<button type="button" class="btn btn-primary"
						data-toggle="collapse" data-target="#filter-panel">
						<span class="glyphicon glyphicon-cog "></span> Advanced Search
					</button>
				</div>
			</div>
			<br>

			<!-- SEARCH RESULTS DISPLAYED HERE --->

			<div class="col-md-12 ">
				<ul class="thumbnails">
					<!--  <li class=" clearfix">
					<div class="thumbnail clearfix">
						<img src="http://placehold.it/320x200" alt="ALT NAME"
							class="pull-left col-md-2 clearfix" style='margin-right: 10px'>
						<div class="caption">
							<a href="viewProfileGeneral"
								class="btn btn-primary icon  pull-right">View Profile</a> <a
								href="http://bootsnipp.com/"
								class="btn btn-success icon  pull-right">Add Friend</a>
							<h4>
								<a href="#">Couple Name</a>
							</h4>
							<small><b>Couple Info: </b><span
								class="coupleName couple-info"> <span class="person1-age">
										p1Age</span> years old <span class="person1-sex"> Male</span> <span
									class="&"> & </span> <span class="person2-age"> p1Age</span>
									years old <span class="person2-sex"> Female</span>
							</span> <br /> <span class="coupleName location"><strong>Current
										Location:</strong><span class="coupleName location"> Boston</span><br />
									<b>What are we looking for: </b><span class="username story">We
										are looking for.... </small>
						</div>
					</div>
				</li>-->
					<div class="displaySearchResults"></div>
				</ul>
			</div>



			<div id="userName" style="display: none">${coupleSU.coupleName}</div>

		</div>

		<!-- /. PAGE INNER  -->
	</div>
	<!-- /. PAGE WRAPPER  -->
	</div>


	<!-- /. WRAPPER  -->

	<footer>
		&copy; 2015 DoubleDate.com | By : <a href="http://www.doubledate.com/"
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


	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script> 

	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		
		
		<!-- Google Maps scripts -->
	<!--   <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script> 
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js"></script>
  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>  -->
<script >
	
		$(document)
				.ready(
						function() {
							//----Search by location-----
							$("#searchLocationButton")
									.click(
											function() {

												var location = $(
														"#searchLocation")
														.val();
												$
														.get(
																"http://localhost:8080/edu/searchByLocation",
																{
																	searchtext : location
																},
																function(data,
																		status) {
																	// check : data is available & status is success
																	//alert("Data: " + data + "\nStatus: " + status);
																	$(
																			".displaySearchResults")
																			.html(
																					data);
																	$(
																			".add-friend-btn")
																			.bind(
																					"click",
																					addFriend);
																});

											});

							//----Search by CoupleName-----	
							$("#coupleNameSearchButton")
									.click(
											function() {
												var coupleName = $(
														"#coupleNameSearchText")
														.val();
												$
														.get(
																"http://localhost:8080/edu/searchByCoupleName",
																{
																	searchtext : coupleName
																},
																function(data,
																		status) {
																	// check : data is available & status is success
																	//alert("Data: " + data + "\nStatus: " + status);
																	$(
																			".displaySearchResults")
																			.html(
																					data);
																	$(
																			".add-friend-btn")
																			.bind(
																					"click",
																					addFriend);
																});

											});

							//----Search by Age-----

							$("#searchByAgeButton")
									.click(
											function() {

												var minimumAge = document
														.getElementById("minAgeText").value;
												var maximumAge = document
														.getElementById("maxAgeText").value;
												$
														.get(
																"http://localhost:8080/edu/searchByCoupleAge?minAge="
																		+ minimumAge
																		+ "&maxAge="
																		+ maximumAge,

																function(data,
																		status) {
																	// check : data is available & status is success
																	//alert("Data: " + data + "\nStatus: " + status);
																	$(
																			".displaySearchResults")
																			.html(
																					data);
																	$(
																			".add-friend-btn")
																			.bind(
																					"click",
																					addFriend);
																});

											});

							//----Search by Activity-----

							$("#activitySearchButton")
									.click(
											function() {

												var activity = $(
														"#activity option:selected")
														.text();
												//alert("Option selected: "+activity);

												$
														.get(
																"http://localhost:8080/edu/searchByCoupleActivity",
																{
																	searchText : activity
																},
																function(data,
																		status) {
																	//alert("Data received: "+data+"\nStatus:"+status);
																	$(
																			".displaySearchResults")
																			.html(
																					data);
																	$(".add-friend-btn").bind("click",	addFriend);
																	//		alert("Selected Activity is :"+activity);

																});

											});

							// ------- Add Friend Request ------- 

							function addFriend() {

								var button = $(this);
								var selectedCoupleDiv = button.next()
										.children();
								var coupleName = selectedCoupleDiv.html();
								var userName = $("#userName").html();
								alert("Couple Name selected is:" + coupleName
										+ "UserName is:" + userName);

								$.post(
										"http://localhost:8080/edu/addFriendRequest?requestFrom="
												+ userName + "&requestTo="
												+ coupleName, function(data,
												status) {
											alert("data is "+data+"\nStatus is:"+status)
											if (data == "Success") {
												
												$(button).html(
														"Friend Request Sent");
												$(button).addClass("disabled");
											}
											else{
												return false;
											}
										});
								
							return false;
							}
							
							
							$(document).on("click", ".add-friend-btn", function (e) {
							    e.preventDefault();
							    if (e.handled !== true) { //Checking for the event whether it has occurred or not.
							        e.handled = true; // Basically setting value that the current event has occurred.
							        alert("Clicked");
							    }
							});
							
							
							// ------- Infinite Scroll ------- 
							
							$contentLoadTriggered = false;
							$(window).scroll(function(){
								if($(window).scrollTop() >= ($(document).height() - $(window).height()) && $contentLoadTriggered == false)
								{
									$contentLoadTriggered = true;
									var location = $("#searchLocation").val();
									var infoId =$(".infoIdValue").last().val();
								
									
									//alert("Info ID is:"+infoId);
							$.get("http://localhost:8080/edu/searchByLocation?searchtext="+location+"&searchId="+infoId,
											
											function(data,
													status) {
												// check : data is available & status is success
												//alert("Data: " + data + "\nStatus: " + status);
												$(".displaySearchResults").append(data);
												$(".add-friend-btn").bind("click",addFriend);
											});
										$contentLoadTriggered = false;
									}
								});
							
							//--------------Auto Complete Search by location------------
							 /* var geocoder = new google.maps.Geocoder();  

							     $(function() {
							         $("#searchLocation").autocomplete({
							         
							           source: function(request, response) {

							          if (geocoder == null){
							           geocoder = new google.maps.Geocoder();
							          }
							             geocoder.geocode( {'address': request.term }, function(results, status) {
							               if (status == google.maps.GeocoderStatus.OK) {

							                  var searchLoc = results[0].geometry.location;
							               var lat = results[0].geometry.location.lat();
							                  var lng = results[0].geometry.location.lng();
							                  var latlng = new google.maps.LatLng(lat, lng);
							                  var bounds = results[0].geometry.bounds;

							                  geocoder.geocode({'latLng': latlng}, function(results1, status1) {
							                      if (status1 == google.maps.GeocoderStatus.OK) {
							                        if (results1[1]) {
							                         response($.map(results1, function(loc) {
							                        return {
							                            label  : loc.formatted_address,
							                            value  : loc.formatted_address,
							                            bounds   : loc.geometry.bounds
							                          }
							                        }));
							                        }
							                      }
							                    });
							            }
							              });
							           },
							           select: function(event,ui){
							      var pos = ui.item.position;
							      var lct = ui.item.locType;
							      var bounds = ui.item.bounds;

							      
							           }
							         });
							     });*/
							
							
						});
	</script>

</body>
</html>
