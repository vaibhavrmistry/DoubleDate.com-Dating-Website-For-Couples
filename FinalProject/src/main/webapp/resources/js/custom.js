     

$(document).ready(function () {

	/*====================================
           METIS MENU 
     ======================================*/

	//$('#main-menu').metisMenu();

	/*======================================
    LOAD APPROPRIATE MENU BAR ON SIZE SCREEN
    ========================================*/

	$(window).bind("load resize", function () {
		if ($(this).width() < 768) {
			$('div.sidebar-collapse').addClass('collapse')
		} else {
			$('div.sidebar-collapse').removeClass('collapse')
		}
	});
	/*======================================
   WRITE YOUR SCRIPTS BELOW
   ========================================*/

	$("#edit-profile-info").hide();




	$('#edit-btn').click(function(){
		
		var p1Sex = $(".p1-sex").html();
		var p2Sex = $(".p2.sex").html();
		
		if(p1Sex == "male")
			{
				$("#p1-sex-male").attr('checked', 'checked');
			}
		else
			{
				$("#p1-sex-female").attr('checked', 'checked');
			}
		
		if(p2Sex == "male")
		{
			$("#p2-sex-male").attr('checked', 'checked');
		}
	else
		{
			$("#p2-sex-female").attr('checked', 'checked');
		}
		
		$('#edit-profile-info').show();
		$("#profile-info").hide();
		
		
		
	});

	$('#save-btn').click(function(){
		
		 
		var age1 = $("#p1-age").val();
		var age2 = $("#p2-age").val();
		var phone1 = $("#p1-phone").val();
		var phone2 = $("#p2-phone").val();

		//check if age is a number or less than or greater than 100 
		if (isNaN(age1)||age1<18||age1>100) 
		{ 
		alert("The age must be a number between 18 and 100");
		return false;

		} 
		if (isNaN(age2)||age2<18||age2>100) 
		{ 
		alert("The age must be a number between 18 and 100");
		return false;

		} 
		if (isNaN(phone1)||phone1<0000000000||phone1>9999999999) 
		{ 
		alert("Please enter valid 10 digit phone number without dashes or spaces");
		return false;

		} 
		if (isNaN(phone2)||phone2<0000000000||phone2>9999999999) 
		{ 
		alert("Please enter valid 10 digit phone number without dashes or spaces");
		return false;

		}

		$('#edit-profile-info').hide();
		$("#profile-info").show();

	});
});
