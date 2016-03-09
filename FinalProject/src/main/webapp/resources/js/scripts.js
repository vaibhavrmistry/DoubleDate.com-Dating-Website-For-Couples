
jQuery(document).ready(function() {

	/*
        Background slideshow
	 */
	$.backstretch([
	               "resources//img/login/couples1.jpg"
	               , "resources//img/login/couples2.jpg"
	               , "resources//img/login/couples3.jpg"
	               , "resources//img/login/couples4.jpg"
	               , "resources//img/login/couples5.jpg"
	               ], {duration: 4000, fade: 750});

	/*
        Tooltips
	 */


	/*
		Sign in Pop-up
	 */
	$(function(){
		$('#loginform').submit(function(){
			//$(this).find("label[for='coupleName']").html("Couple Name");
			//$(this).find("label[for='password']").html("Password");

			var coupleName= $("#coupleName").val();
			var password = $("#password").val();

			if(coupleName == ''){
				$(".couple-name-error").html("Please enter a valid couple Name.");
				$('#modaltrigger').leanModal();
				return false;
			}
			else
			{
				$(".couple-name-error").hide();
				return true;
			}

			if(password == ''){
				$(".password-error").html("Please enter a valid password.");
				//$(this).find("label[for='password'] span").fadeIn('medium');
				$('#modaltrigger').leanModal();
				return false;
			}
			else{
				$(".password-error").hide();
				return true;
			}
		});

		$('#modaltrigger').leanModal();
	});

	/*
        Form validation
	 */
	$("#re-password").blur(function(){

		var pass = $("#register-password").val();
		var rePass = $("#re-password").val();

		if(pass != rePass)
		{
			$(".re-password").html("Passwords don't match!");
		}
		else{
			$(".re-password").html(" ");
		}

	});
	
	$("#register-btn").click(function(){
		
	
		var name = $("#couplename").val();
		
		
		
		$.get("http://localhost:8080/edu/checkUniqueUsername",
				{
			coupleName : name
				},
				function(data,
						status) {
					if(data == "true"){
						
						$(".unique-couple-name").html("Couple Name Unique!");
						
					}
					else 
					{	
						$(".unique-couple-name").html("Couple Name already taken. Please select another name");
						
					}
				});
			
			if($(".unique-couple-name").html() == "Couple Name already taken. Please select another name")
				return false
		

			var pass = $("#register-password").val();
			var rePass = $("#re-password").val();
			
			if(rePass == "")
				{
				$(".re-password").html("Please re-enter password!");
				return false;
				
				}
			
			
			if(pass != rePass )
			{
				$(".re-password").html("Passwords don't match!");
				return false;
				
			}
			
			
			
			
		
	});


	$('.register form').submit(function(){
//		$(this).find("label[for='coupleName']").html('Couple Name');
//		$(this).find("label[for='email']").html('Email');
//		$(this).find("label[for='password']").html('Password');
		////

		var coupleName = $(this).find('#couplename').val();
		var email = $(this).find('#email').val();
		var password = $(this).find('#register-password').val();

		if(coupleName == '') {
			$(".couple-validation").html("<span class='red'> - Please enter a valid Couple Name.</span>");
			return false;
		}
		else{
			$(".couple-validation").hide();
		}
		if(email == '') {
			$(".email-validation").html("<span class='red'> - Please enter a valid email.</span>");

			return false;
		}
		else{
			$(".email-validation").hide();
		}
		if(password == '') {
			$(".password-validation").html("<span class='red'> - Please enter a valid password.</span>");

			return false;
		}
		else{
			$(".password-validation").hide();
		}
	});
});


