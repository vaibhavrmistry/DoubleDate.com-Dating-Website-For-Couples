package com.neu.edu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.edu.DAO.CoupleSignUpDAO;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Role;

@Controller
public class SignUpController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


//		@Autowired
//		@Qualifier("signUpValidator")
//		private Validator validator;
	
	@Autowired
	private CoupleSignUpDAO csuDAO;
	
//		@InitBinder	
//		private void InitBinder(WebDataBinder webDataBinder){
//			webDataBinder.setValidator(validator);
//		}
	


	@RequestMapping(value="/register", method=RequestMethod.POST)
	private String registerCouple(Model model, @ModelAttribute("coupleSignUp") CoupleSignUp coupleSignUp){
		
		String success = csuDAO.AddSignUpCouple(coupleSignUp);
		model.addAttribute("coupleSignnUp", coupleSignUp);
		return "login";
	}
	
	@RequestMapping(value = "/checkUniqueUsername", method = RequestMethod.GET , produces="application/text")
	public @ResponseBody String checkUsernameUnique(HttpServletRequest request, HttpServletResponse response)
	{	
		
		String userName = request.getParameter("coupleName");
		boolean results = csuDAO.checkUserName(userName);
		
		if(results == true)
		{
			return "true";
		}
		else
		{
			return "false";
		}
		
		
		
	}

}
