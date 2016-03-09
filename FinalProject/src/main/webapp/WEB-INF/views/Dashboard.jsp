<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<csrf disabled="true"/>
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
<csrf disabled="true"/>
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
								class="img-circle profile-image" onclick="return false"
								onerror="this.src='resources//img/Dashboard/defaultProfile.jpg';" />


						</div>

					</li>
					<li><a href="#"> <strong> ${coupleSU.coupleName} </strong></a></li>

					<li><a class="active-menu" href="generalDashboard"> <i
							class="fa fa fa-user""></i>My Profile
					</a></li>
					<li><a href="searchPage"><i class="fa fa-search "></i>Search
					</a></li>

					<li><a href="findAllChatters"><i class="fa fa-envelope "></i>Messages
					</a></li>

					<li><a href="searchAllAccepted"><i class="fa fa-users "></i>Friends</a>
					</li>

					<li><a href="logout"><i class="fa fa-power-off "></i>Logout</a></li>

				</ul>
			</div>

		</nav>
		<!-- /. SIDEBAR MENU (navbar-side) -->
		<div id="page-wrapper" class="page-wrapper-cls">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h1 class="page-head-line">My Profile</h1>
					</div>
				</div>

				<div id="profile-info" class="container target">
					<div class="row">
						<div class="col-sm-10">
							<h1 class="couple-name">${coupleSU.coupleName}
								</h1>

							<button type="button" class="btn btn-info" id="edit-btn"><i class="fa fa-pencil-square-o"></i> Edit
								Profile</button>
							<br>
						</div>
						<div class="col-sm-2">
							<a href="/users" class="pull-right"><img
								title="profile image"
								class="img-circle img-responsive profile-image"
								src='/profileImages/${coupleSU.coupleName}.jpg'
								onerror="this.src='resources//img/Dashboard/defaultProfile.jpg';"></a>
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-3 ">
							<!--left col-->
							<ul class="list-group ">
								<li class="list-group-item text-muted side-column side-column" contenteditable="false">Person 1 Info</li>
								<li class="list-group-item text-right age side-column"><span
									class="pull-left"><strong class="">First Name</strong></span><span
									class="p1-fname">${coupleInfo.getPersonList().get(0).firstName}</span></li>

								<li class="list-group-item text-right age side-column"><span
									class="pull-left"><strong class="">Last Name</strong></span><span
									class="p1-lname">${coupleInfo.getPersonList().get(0).lastName}</span></li>

								<li class="list-group-item text-right age side-column"><span
									class="pull-left"><strong class="">Age</strong></span><span
									class="p1-age">${coupleInfo.getPersonList().get(0).age}</span></li>
								<li class="list-group-item text-right hometown side-column"><span
									class="pull-left"><strong class="">Hometown</strong></span><span
									class="p1-hometown">${coupleInfo.getPersonList().get(0).hometown}</span></li>
								<li class="list-group-item text-right occupation side-column"><span
									class="pull-left"><strong class="">Occupation</strong></span><span
									class="p1-occupation">${coupleInfo.getPersonList().get(0).occupation}</span></li>
								<li class="list-group-item text-right occupation side-column"><span
									class="pull-left"><strong class="">Email
											Address</strong></span><span class="p1-email">${coupleInfo.getPersonList().get(0).emailId}</span></li>
								<li class="list-group-item text-right occupation side-column"><span
									class="pull-left"><strong class="">Phone</strong></span><span
									class="p1-phone">${coupleInfo.getPersonList().get(0).phone}</span></li>
								<li class="list-group-item text-right occupation side-column"><span
									class="pull-left"><strong class="">Sex</strong></span><span
									class="p1-sex">${coupleInfo.getPersonList().get(0).sex}</span></li>



							</ul>
							<ul class="list-group">
								<li class="list-group-item text-muted side-column" contenteditable="false">Person 2 Info</li>
								<li class="list-group-item text-right age side-column"><span
									class="pull-left"><strong class="">First Name</strong></span><span
									class="p2-fname">${coupleInfo.getPersonList().get(1).firstName}</span></li>

								<li class="list-group-item text-right age side-column"><span
									class="pull-left"><strong class="">Last Name</strong></span><span
									class="p2-lname">${coupleInfo.getPersonList().get(1).lastName}</span></li>

								<li class="list-group-item text-right age side-column"><span
									class="pull-left"><strong class="">Age</strong></span><span
									class="p2-age">${coupleInfo.getPersonList().get(1).age}</span></li>
								<li class="list-group-item text-right hometown side-column"><span
									class="pull-left"><strong class="">Hometown</strong></span><span
									class="p2-hometown">${coupleInfo.getPersonList().get(1).hometown}</span></li>
								<li class="list-group-item text-right occupation side-column"><span
									class="pull-left"><strong class="">Occupation</strong></span><span
									class="p2-occupation">${coupleInfo.getPersonList().get(1).occupation}</span></li>
								<li class="list-group-item text-right occupation side-column"><span
									class="pull-left"><strong class="">Email
											Address</strong></span><span class="p2-email">${coupleInfo.getPersonList().get(1).emailId}</span></li>
								<li class="list-group-item text-right occupation side-column"><span
									class="pull-left"><strong class="">Phone</strong></span><span
									class="p2-phone">${coupleInfo.getPersonList().get(1).phone}</span></li>
								<li class="list-group-item text-right occupation side-column"><span
									class="pull-left"><strong class="">Sex</strong></span><span
									class="p2-sex">${coupleInfo.getPersonList().get(1).sex}</span></li>

							</ul>
							<div class="panel panel-default">
								<div class="panel-heading">Current Location</div>
								<div class="panel-body">
									<i class="fa fa-map-marker curr-location"></i><span
										class="curr-location">${coupleInfo.location}</span>

								</div>
							</div>

						</div>
						<!--/col-3-->
						<div class="col-sm-9" contenteditable="false" style="">
							<div class="panel panel-default">
								<div class="panel-heading">Our Story</div>
								<div class="panel-body story">${coupleInfo.story}</div>
							</div>

							<!-- Activity section -->

							<div class="panel panel-default">
								<div class="panel-heading">Activities we like</div>
								<c:forEach var="activity" items="${activityListing}">
									<div class="panel-body activities-display">${activity.activityName}</div>
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
													<p class="restaurant">${coupleInfo.restaurants}</p>
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
													<p class="artist">${coupleInfo.musicArtists}</p>
													<p></p>
												</div>
											</div>
										</div>


									</div>

								</div>

							</div>
							<div class="panel panel-default">
								<div class="panel-heading">What are we looking for</div>
								<div class="panel-body looking-for">${coupleInfo.lookingfor}</div>
							</div>
						</div>


						<div id="push"></div>
					</div>


					<!-- <script src="/plugins/bootstrap-select.min.js"></script>
        <script src="/codemirror/jquery.codemirror.js"></script>
        <script src="/beautifier.js"></script>-->


				</div>

				<!-- Edit Profile DIV -->
				<div id="edit-profile-info" class="container target">
					<div class="row">
						<div class="col-sm-8">

							<h1 class="">${coupleSU.coupleName}</h1>


							<br>
						</div>
						<div class="col-sm-4">

							<img title="profile image"
								class="img-circle img-responsive profile-img"
								src='/profileImages/${coupleSU.coupleName}.jpg'
								onerror="this.src='resources//img/Dashboard/defaultProfile.jpg';" />

							<h6>Upload a different photo...</h6>
							<form:form method="post" action="uploadFile.htm" name="file"
								enctype="multipart/form-data">
								<input type="file" id="exampleInputFile" name="file"
									required="required" class="form-control" />
								<input type="submit" value="change Image"
									class="btn btn-success" />
							</form:form>
						</div>

						<form method="post" action="dashboardAdd">
							<div class="col-sm-12">


								<button type="submit" id="save-btn" class="btn btn-info"><i class="fa fa-floppy-o"></i>Save
									Profile</button>
							</div>
					</div>
					<br>
					<div class="row">

						<div class="col-sm-3">
							<!--left col-->
							<ul class="list-group">

								<li class="list-group-item text-muted" contenteditable="false">Person
									1 Info</li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">First Name</strong></span> <input
									type="text" required="required" class="form-control" id="p1-fname"
									name="firstName1" placeholder="Enter First Name of Person 1"
									value="${coupleInfo.getPersonList().get(0).firstName}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Last Name</strong></span> <input
									type="text" required="required" class="form-control" id="p1-lname"
									name="lastName1" placeholder="Enter Last Name of Person 1"
									value="${coupleInfo.getPersonList().get(0).lastName}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Age</strong></span> <input
									type="text"  class="form-control" id="p1-age" name="age1"
									placeholder="enter Age of Person 1"
									value="${coupleInfo.getPersonList().get(0).age}"
									required="required"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Sex</strong></span><input
									type="radio"  name="sex1" value="male" class="" id="p1-sex-male">Male
									<input type="radio" name="sex1" value="female" class=""
									id="p1-sex-female">Female</li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Hometown</strong></span> <input
									type="text" required="required" class="form-control" id="p1-loc" name="hometown1"
									placeholder="Enter Hometown of Person1"
									value="${coupleInfo.getPersonList().get(0).hometown}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Occupation</strong></span> <input
									type="text" required="required" class="form-control" id="p1-occ" name="occupation1"
									placeholder="Enter Occupation of Person1"
									value="${coupleInfo.getPersonList().get(0).occupation}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Phone number</strong></span>
									<input type="text" required="required" class="form-control" id="p1-phone"
									name="phone1" placeholder="Enter Phone of Person1"
									value="${coupleInfo.getPersonList().get(0).phone}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Email</strong></span> <input
									type="text" required="required" class="form-control" id="p1-occ" name="email1"
									placeholder="Enter email of Person1"
									value="${coupleInfo.getPersonList().get(0).emailId}"></li>
							</ul>
							<ul class="list-group">
								<li class="list-group-item text-muted" contenteditable="false">Person
									2 Info</li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">First Name</strong></span> <input
									type="text" required="required" class="form-control" id="first-name"
									name="firstName2" placeholder="Enter First Name of Person 2"
									value="${coupleInfo.getPersonList().get(1).firstName}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Last Name</strong></span> <input
									type="text" required="required" class="form-control" id="first-name"
									name="lastName2" placeholder="Enter Last Name of Person 2"
									value="${coupleInfo.getPersonList().get(1).lastName}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Age</strong></span> <input
									type="text" required="required" class="form-control" id="p2-age" 
									name="age2" value="${coupleInfo.getPersonList().get(1).age}"
									required="required"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Sex</strong></span> <input
									type="radio"  name="sex2" value="male" class="" id="p2-sex-male">Male
									<input type="radio" name="sex2" value="female" class=""
									id="p2-sex-female">Female</li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Hometown</strong></span> <input
									type="text" required="required"class="form-control" id="p2-loc"
									name="hometown2"
									value="${coupleInfo.getPersonList().get(1).hometown}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Occupation</strong></span> <input
									type="text" required="required" class="form-control" id="p2-occ" name="occupation2"
									placeholder="Finance"
									value="${coupleInfo.getPersonList().get(1).occupation}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Phone number</strong></span>
									<input type="text" required="required" class="form-control" id="p2-phone"
									name="phone2" 
									value="${coupleInfo.getPersonList().get(1).phone}"></li>
								<li class="list-group-item text-right"><span
									class="pull-left"><strong class="">Email</strong></span> <input
									type="text" required="required" class="form-control" id="p2-email" name="email2"
									
									value="${coupleInfo.getPersonList().get(1).emailId}"></li>

							</ul>
							

						</div>

						<!--/col-3-->
						<div class="col-sm-9" contenteditable="false" style="">
							<div class="panel panel-default">
								<div class="panel-heading">Our Story</div>
								<div class="panel-body">
									<textarea class="form-control" required="required" name="story" value="" rows="3">${coupleInfo.story}</textarea>

								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">Activities we like</div>
								<div class="panel-body">
										<c:if test="${activityListing == null}">
											<c:forEach var="activity" items="${allActivities}"> 
											
										<input type="checkbox" name="activity" class="activities-input"
											value="${activity.activityName}">${activity.activityName}
											
											
											</c:forEach>
											
											</c:if>
										
										<c:forEach var="selectedActivity" items="${activityListing}"> 
											
										<input type="checkbox" name="activity" class="activities-input"
											value="${selectedActivity.activityName}" checked="checked">${selectedActivity.activityName}
											
											
											</c:forEach>
											
											<c:forEach var="activity" items="${pendingActivities}">
											
											<input type="checkbox" name="activity" class="activities-input"
											value="${activity.activityName}">${activity.activityName}
											
									</c:forEach>

								</div>
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
													<p>
														<textarea class="form-control" rows="2" name="restaurants">${coupleInfo.restaurants}</textarea>
													</p>
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
													<p>
														<textarea class="form-control" rows="2"
															name="musicArtists">${coupleInfo.musicArtists}</textarea>
													</p>
													<p></p>
												</div>
											</div>
										</div>


									</div>

								</div>

							</div>
							<div class="panel panel-default">
								<div class="panel-heading">What are we looking for</div>
								<div class="panel-body">
									<textarea class="form-control" required="required" rows="3" name="lookingFor">${coupleInfo.lookingfor}</textarea>


								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">Current Location</div>
								<div class="panel-body">
									 
								
								<div align="left">
								<i class="fa fa-map-marker "></i><input type="text" value="${coupleInfo.location}" required="required" class="form-control curr-loc" placeholder="Enter Current Location" id="searchbox" name="location"
										 /> </div>
								<div class="panel-body" id="map" style="width:100%; height: 350px; margin-top: 10px;" >
								</div>
								
							</div>
							</form>
							
						</div>

					</div>



					<div id="push col-md-12"><button class="btn btn-default col-md-12" id="scroll-up">Click to scroll up</button></div>
				</div>
				<!-- /. PAGE INNER  -->
			</div>
			<!-- /. PAGE WRAPPER  -->
		</div>
	</div>
	<!-- /. WRAPPER  -->
	<footer>
		&copy; 2015 DoubleDate.com | By :<a href="http://www.DoubleDate.com/"
			target="_blank">DoubleDate</a>
	</footer>
	<!-- /. FOOTER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	 <script src="resources//js/jquery-1.11.1.js"></script> 
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<!-- METISMENU SCRIPTS -->
	<script src="resources//js/jquery.metisMenu.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="resources//js/custom.js"></script>
	 <script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
		
	<!-- Google Maps scripts -->
	 <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script> 
  <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script> 
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js"></script>
  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>  
<script type="text/javascript">
 $(document).ready(function(){
	 
	 
	 $("#scroll-up").click(function(){
		 
		 $('html, body').animate({
			    scrollTop: $("#save-btn").offset().top
			}, 1000);
		 
	 });
	 
	
  var mapOptions = {
       zoom: 10,
       mapTypeId: google.maps.MapTypeId.ROADMAP,
       center: new google.maps.LatLng(42.348078,-71.077766)
     };

  var map = new google.maps.Map(document.getElementById("map"),mapOptions);

  var geocoder = new google.maps.Geocoder();  

     $(function() {
         $("#searchbox").autocomplete({
         
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

      if (bounds){
       map.fitBounds(bounds);
      }
           }
         });
     });
     
     $("#searchbox").keydown(function(event){
    	    if(event.keyCode == 13) {
    	      
    	          event.preventDefault();
    	          return false;
    	      
    	    }
    	 });
     
     
 });
</script>
</body>
</html>
