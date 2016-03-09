package com.neu.edu;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import antlr.CppCodeGenerator;

import com.neu.edu.DAO.CoupleSignUpDAO;
import com.neu.edu.DAO.DBStaticDataDAO;
import com.neu.edu.Model.Activities;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Person;
import com.neu.edu.Validator.LoginValidator;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	@Qualifier("loginValidator")
	private Validator validator;

	@Autowired
	private CoupleSignUpDAO csuDAO;
	@Autowired
	private DBStaticDataDAO dbStaticDataDAO;
	@Autowired
	private CoupleSignUpDAO coupleSignUpDAO;

	@InitBinder("csu")
	private void InitBinder(WebDataBinder webDataBinder){
		webDataBinder.setValidator(validator);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value ="/", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request, HttpServletResponse response) {
		CoupleSignUp csu = new CoupleSignUp();
		//fetching data for remember me from cookies
		//		Cookie[] cookies = request.getCookies();
		//		String key = null;
		//		for(Cookie cookie : cookies){
		//			if("key".equals(cookie.getName())){
		//				key = cookie.getValue();
		//			}
		//		}


		model.addAttribute("coupleSignUp", csu);
		return "login";
	}


	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		return "forward:/login";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String generalError(Model model) {
		return "error";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginCheck(Model model,  HttpServletRequest request, HttpServletResponse response, @Validated CoupleSignUp csu, BindingResult result){

//		//HttpSession session = request.getSession();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object userPrincipal = authentication.getPrincipal();

		if(userPrincipal instanceof User){
			String coupleNm = ((User) userPrincipal).getUsername();
			try {

				if(coupleNm != null){
					CoupleSignUp coupleSU = coupleSignUpDAO.getSignUpUsingName(coupleNm);
					if(coupleSU!= null){
						model.addAttribute("coupleLogin", coupleSU);
						HttpSession session = request.getSession();
						session.setAttribute("coupleSU", coupleSU);
						CoupleInfo coupleInfo = new CoupleInfo();
						// getting activity from the database for every user from DBStaticDAO
						ArrayList<Activities> activityList = dbStaticDataDAO.gettingActivities();
						model.addAttribute("coupleInfo", coupleInfo);
						model.addAttribute("allActivities", activityList);
						session.setAttribute("allActivities", activityList);
						CoupleInfo coupleInfo1 = csuDAO.getUserData(coupleSU.getCoupleName());
						if(coupleInfo1 == null){
							return "Dashboard";
						} else{
							model.addAttribute("coupleInfo", coupleInfo1);
							List<Activities> activList = coupleInfo1.getActivityList();
							HashSet<Activities> activities = new HashSet<Activities>();
							activities.addAll(activList);
							model.addAttribute("activityListing", activities );
							HashSet<Activities> uncheckedActivities = new HashSet<Activities>();
							boolean flag = true;
							//passing un-checked activities 
							for(Activities allActivity :activityList)
							{
								for(Activities activity :activities)
								{
									if(activity.getActivityName().equalsIgnoreCase(allActivity.getActivityName()))
									{
										flag = false;
									}
								}
								if(flag)
									uncheckedActivities.add(allActivity);
							}
							session.setAttribute("pendingActivities", uncheckedActivities);
							return "Dashboard";
							//	HashSet<Activities> uncheckedActivities = new HashSet<Activities>();
						}

					}

				} else {
					String error = "Sorry this account does not exist, try with other user account details.";
					//		Object mainError = error;
					//		HttpSession session = request.getSession();
					model.addAttribute("error", error);
					return "login";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

		}
		return "login";
//		return "Dashboard";
	}
	
	
	

}
