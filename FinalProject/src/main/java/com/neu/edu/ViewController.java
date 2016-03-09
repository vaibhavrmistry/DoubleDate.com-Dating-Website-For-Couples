package com.neu.edu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.edu.DAO.CoupleInfoDAO;
import com.neu.edu.Model.Activities;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Person;

@Controller
public class ViewController {

	@Autowired
	private CoupleInfoDAO coupleInfoDAO;


	@RequestMapping(value = "/profileView", method = RequestMethod.GET)
	public String viewprofilePageGeneral(Model model, @RequestParam("viewCoupleName") String viewCoupleName, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//	CoupleInfo loginUSer = (CoupleInfo) session.getAttribute("");
		// call to get the coupleinfo for the viewed couple usng couplename from 
		CoupleSignUp viewCoupleData = coupleInfoDAO.fetchViewCouple(viewCoupleName);

		CoupleInfo viewCouple = viewCoupleData.getCoupleInfo();
		List<Activities> actList = viewCouple.getActivityList();
		HashSet<Activities> activities = new HashSet<Activities>();
		activities.addAll(actList);
		Person person1 = viewCouple.getPersonList().get(0);
		Person person2 = viewCouple.getPersonList().get(1);

		// getting the male and female person information from the couple infor so as to 
		model.addAttribute("viewCoupleName",viewCoupleData);
		model.addAttribute("viewCoupleInfo", viewCouple);
		model.addAttribute("activityList", activities);
		model.addAttribute("person1", person1);
		model.addAttribute("person2", person2);
		return "viewSearchProfile";
	}

	@RequestMapping(value = "/profileViewFriend", method = RequestMethod.GET)
	public String viewprofilePageFriend(Model model, @RequestParam("viewCoupleName") String viewCoupleName, HttpServletRequest request) {
		HttpSession session = request.getSession();
		//	CoupleInfo loginUSer = (CoupleInfo) session.getAttribute("");
		// call to get the coupleinfo for the viewed couple usng couplename from 

		CoupleSignUp viewCoupleData = coupleInfoDAO.fetchViewCouple(viewCoupleName);

		CoupleInfo viewCouple = viewCoupleData.getCoupleInfo();
		List<Activities> actList = viewCouple.getActivityList();
		HashSet<Activities> activities = new HashSet<Activities>();
		activities.addAll(actList);


		// getting the male and female person information from the couple infor so as to 
		model.addAttribute("viewCoupleName",viewCoupleData);
		model.addAttribute("viewCoupleInfo", viewCouple);
		model.addAttribute("activityList", activities);
		return "viewFriendsProfile";
	}



}
