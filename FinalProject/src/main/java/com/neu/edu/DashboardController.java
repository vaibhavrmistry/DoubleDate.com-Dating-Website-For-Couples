package com.neu.edu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.neu.edu.DAO.CoupleInfoDAO;
import com.neu.edu.DAO.CoupleSignUpDAO;
import com.neu.edu.Model.Activities;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Person;


@Controller
public class DashboardController {

	@Autowired
	private CoupleInfoDAO coupleInfoDAO;
	
	



	
	@RequestMapping("/dashboardAdd")
	public String dashbboardEditProfile(Model model, HttpServletRequest request){

		
		
		String firstName1 = request.getParameter("firstName1");
		String lastName1 = request.getParameter("lastName1");
		int age1 = Integer.parseInt(request.getParameter("age1"));
		String hometown1 = request.getParameter("hometown1");
		String occupation1 = request.getParameter("occupation1");
		String sex1 = request.getParameter("sex1");
		String phone1 = request.getParameter("phone1");
		String email1 = request.getParameter("email1");
	
		
		Person person1 = new Person();
		person1.setFirstName(firstName1);
		person1.setLastName(lastName1);
		person1.setAge(age1);
		person1.setHometown(hometown1);
		person1.setOccupation(occupation1);
		person1.setSex(sex1);
		person1.setPhone(phone1);
		person1.setEmailId(email1);


		String firstName2 = request.getParameter("firstName2");
		String lastName2 = request.getParameter("lastName2");
		int age2 = Integer.parseInt(request.getParameter("age2"));
		String hometown2 = request.getParameter("hometown2");
		String occupation2 = request.getParameter("occupation2");
		String sex2 = request.getParameter("sex2");
		String phone2 = request.getParameter("phone2");
		String email2 = request.getParameter("email2");
		
		
		Person person2 = new Person();
		person2.setFirstName(firstName2);
		person2.setLastName(lastName2);
		person2.setAge(age2);
		person2.setHometown(hometown2);
		person2.setOccupation(occupation2);
		person2.setSex(sex2);
		person2.setPhone(phone2);
		person2.setEmailId(email2);	
		
		String currectLoc = request.getParameter("location");
		System.out.println("Current Location is:"+currectLoc);
		String  story = request.getParameter("story");
		String lookingFor = request.getParameter("lookingFor");
		String restaurants = request.getParameter("restaurants");
		
		String musicArtists = request.getParameter("musicArtists");
		
		System.out.println("Restaurants ARE: "+restaurants+"\t musicArtists ARE:"+musicArtists);
		HttpSession session = request.getSession();
		CoupleSignUp csu = (CoupleSignUp) session.getAttribute("coupleSU");
		String[] actSel = request.getParameterValues("activity"); 
		System.out.println("the size of activity strings " + actSel.length);
		ArrayList<Activities> activitiesList = coupleInfoDAO.retreiveActivity(actSel);

		CoupleInfo coupleInfo = new CoupleInfo();
		coupleInfo.setLocation(currectLoc);
		coupleInfo.setStory(story);
		coupleInfo.setLookingfor(lookingFor);
		//if(musicArtists != null)
		coupleInfo.setMusicArtists(musicArtists);
		//if(restaurants != null)
		coupleInfo.setRestaurants(restaurants);
		
		
		CoupleInfo coupleInfo2 =  coupleInfoDAO.addCoupleInfo(person1, person2, coupleInfo, csu, activitiesList);
		List<Activities> listact = coupleInfo2.getActivityList();
		model.addAttribute("activityListing", listact);
		model.addAttribute("coupleInfo", coupleInfo2);
		return "Dashboard";
	}


	@RequestMapping(value = "/uploadFile.htm", method = RequestMethod.POST)
    public String uploadFileHandler(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, Model model) throws IllegalStateException, IOException {
		
		HttpSession session =  request.getSession();
		CoupleSignUp coupleObject = (CoupleSignUp) session.getAttribute("coupleSU");
		String coupleName = coupleObject.getCoupleName();
       
    	String fileName = file.getOriginalFilename();
    	String [] nameString = fileName.split("\\.");
		String originalName1 = nameString[0];
		String extenssion = nameString[1];
		
        File dest = new File("/Users/Vaibhav/Desktop/FinalProject/images/"+coupleName+".jpg");
        file.transferTo(dest);
        System.out.println(dest.toString());
        
        CoupleInfo ci = coupleObject.getCoupleInfo();
		List<Activities> activList = (List<Activities>) ci.getActivityList();
		HashSet<Activities> activities = new HashSet<Activities>();
		activities.addAll(activList);
		model.addAttribute("activityListing", activities );
		model.addAttribute("coupleSU", coupleObject);
		model.addAttribute("coupleInfo", ci);
		model.addAttribute("activityListing", activities);
        
        return "Dashboard";

}
	
	
	@RequestMapping(value = "/generalDashboard", method = RequestMethod.GET)
	public String generalDashboard(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		CoupleSignUp csu = (CoupleSignUp) session.getAttribute("coupleSU");
	if (csu != null){
		CoupleInfo ci = csu.getCoupleInfo();
	
		if(ci != null)
		{List<Activities> activList = (List<Activities>) ci.getActivityList();
		HashSet<Activities> activities = new HashSet<Activities>();
		activities.addAll(activList);
		model.addAttribute("activityListing", activities );
		}
		model.addAttribute("coupleSU", csu);
		model.addAttribute("coupleInfo", ci);
		return "Dashboard";
	}

	session.invalidate();
	return "forward:logout";
		
	}


	

}
