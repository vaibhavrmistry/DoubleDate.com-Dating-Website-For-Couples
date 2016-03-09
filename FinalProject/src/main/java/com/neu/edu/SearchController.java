package com.neu.edu;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;















import com.neu.edu.DAO.CoupleInfoDAO;
import com.neu.edu.DAO.DBStaticDataDAO;
import com.neu.edu.DAO.FriendsDAO;
import com.neu.edu.DAO.SearchDAO;
import com.neu.edu.Model.Activities;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Person;




@Controller
public class SearchController {

	@Autowired
	private SearchDAO searchDAO;
	
	@Autowired
	private FriendsDAO friendsDAO;
	
	@Autowired
	private CoupleInfoDAO coupleInfoDAO;
	
	@Autowired
	private DBStaticDataDAO activitiyDAO;
	//	public SearchController() {
	//		// TODO Auto-generated constructor stub
	//
	//		searchDAO = new SearchDAO();
	//		activitiyDAO = new DBStaticDataDAO();
	//	}

	@RequestMapping(value = "/searchPage", method = RequestMethod.GET)
	public String searchPage(Model model) {
		ArrayList<Activities> activityList = activitiyDAO.gettingActivities();
		for(Activities act : activityList){
			System.out.println("name of activities " + act.getActivityName());
		}
		model.addAttribute("activityAll", activityList);
		return "search";
	}


	@RequestMapping(value = "/searchByLocation", method = RequestMethod.GET, produces="application/text")
	public  @ResponseBody String searchCoupleByLoction(HttpServletRequest request, HttpServletResponse response) {

		//PersonList personList = new PersonList();
		//ArrayList<Person> persons = personList.getPersonList();
		String location = request.getParameter("searchtext");
		int infoId = 0;
		if(request.getParameter("searchId") != null)
		{
			infoId = Integer.parseInt(request.getParameter("searchId"));
		
		}
		StringBuffer result = new StringBuffer("");
		HttpSession session = request.getSession();
		CoupleSignUp user = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleInfo userCoupleInfo = user.getCoupleInfo();
		
		ArrayList<CoupleInfo> coupleList = new ArrayList<CoupleInfo>();
		
		//Get Friend List and compare:
				
		ArrayList<CoupleSignUp> coupleFriends = friendsDAO.mytotalFriends(user);
		//ArrayList<CoupleInfo> coupleFriendsInfo = new ArrayList<CoupleInfo>();
		ArrayList<CoupleInfo> coupleInfoList1 = new ArrayList<CoupleInfo>();
		ArrayList<CoupleSignUp> pendingFriends = friendsDAO.requestSentPending(user);
		
		for(CoupleSignUp csu : coupleFriends){
			CoupleInfo cinfo = csu.getCoupleInfo();
			coupleInfoList1.add(cinfo);
		}
		
		for(CoupleSignUp csu2 : pendingFriends){
			CoupleInfo cinfo2 = csu2.getCoupleInfo();
			coupleInfoList1.add(cinfo2);
		}
		
		
		boolean flag = false;
		
		try {
			coupleList = searchDAO.searchCouplesByLocation(location, infoId);

			for(CoupleInfo couple : coupleList)
			{	
				
				if(!(userCoupleInfo.getInfo_Id() == couple.getInfo_Id()))
				{	
					flag = false;
					System.out.println("Reached Here");
					for(CoupleInfo friend : coupleInfoList1)
					if(friend.getInfo_Id() == couple.getInfo_Id())
					{	flag = true;
						Person p1 = (Person)couple.getPersonList().get(0);
				Person p2 = (Person)couple.getPersonList().get(1);
					infoId = couple.getInfo_Id();

				result = result.append("<li class=' clearfix'>"
						+ "<div class='thumbnail clearfix'>"+
						"<img src='/profileImages/"+searchDAO.getCoupleName(couple.getInfo_Id())+".jpg' class='img-circle col-md-2 clearfix'" +
						"onclick='return false' style='margin-right: 10px' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" />"
						+
						"<div class='caption'>"+
						"<form action='profileViewFriend' method='get'><input type='hidden' name='viewCoupleName' value='"+searchDAO.getCoupleName(friend.getInfo_Id())+"'/> "+
						"<button type='submit' "+
						"class='btn btn-primary icon  pull-right view-profile-btn'>View Profile</button></form>"
						+ "<a  class='btn btn-success icon  pull-right disabled'>Friend added</a>"
						+"<h4>"
						+"<a >"+searchDAO.getCoupleName(couple.getInfo_Id())+"</a>"
						+"</h4>"+
						"<b>Couple Info: </b><span" +
						"class='coupleName couple-info'> <span class='person1-age'>" +
						p1.getAge()+"</span> years old <span class='person1-sex'>"+ p1.getSex()+"</span> <span"
						+"class='&'> & </span> <span class='person2-age'>"+ p2.getAge() +"</span>"+
						"years old <span class='person2-sex'>"+ p2.getSex()+"</span>"+
						"</span> <br /> <span class='coupleName location'><strong>Current"+
						"Location:</strong><span class='coupleName location'>"+ couple.getLocation()+"</span><br />"+
						"<b> What are we looking for: </b><span class='username story'> "+couple.getLookingfor()+"</div></li>");
						break;
					}
					
					if(flag==false)
					{
						Person p1 = (Person)couple.getPersonList().get(0);
						Person p2 = (Person)couple.getPersonList().get(1);
							infoId = couple.getInfo_Id();

						result = result.append("<li class=' clearfix'>"
								+ "<div class='thumbnail clearfix'>"+
								"<img src='/profileImages/"+searchDAO.getCoupleName(couple.getInfo_Id())+".jpg' class='img-circle col-md-2 clearfix'" +
								"onclick='return false' style='margin-right: 10px' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" />"
								+
								"<div class='caption'>"+
								"<form action='profileView' method='get'><input type='hidden' name='viewCoupleName' value='"+searchDAO.getCoupleName(couple.getInfo_Id())+"'/> "+
								"<button type='submit' "+
								"class='btn btn-primary icon  pull-right view-profile-btn'>View Profile</button></form>"
								+ "<a  class='btn btn-success icon  pull-right add-friend-btn'>Add Friend</a>"
								+"<h4>"
								+"<a >"+searchDAO.getCoupleName(couple.getInfo_Id())+"</a>"
								+"</h4>"+
								"<b>Couple Info: </b><span" +
								"class='coupleName couple-info'> <span class='person1-age'>" +
								p1.getAge()+"</span> years old <span class='person1-sex'>"+ p1.getSex()+"</span> <span"
								+"class='&'> & </span> <span class='person2-age'>"+ p2.getAge() +"</span>"+
								"years old <span class='person2-sex'>"+ p2.getSex()+"</span>"+
								"</span> <br /> <span class='coupleName location'><strong>Current"+
								"Location:</strong><span class='coupleName location'>"+ couple.getLocation()+"</span><br />"+
								"<b> What are we looking for: </b><span class='username story'> "+couple.getLookingfor()+"</div></li>");
					}
					
					}
					
					
					
					
					
					
			}
			
			result = result.append("<input class='infoIdValue' type='hidden' name='infoId' value='"+infoId+"'/>");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error is: "+ e);
			e.printStackTrace();
		}

		return  result.toString();
	}


	@RequestMapping(value = "/searchByCoupleName", method = RequestMethod.GET, produces="application/text")
	public  @ResponseBody String searchCoupleByCoupleName(HttpServletRequest request, HttpServletResponse response) {

		//PersonList personList = new PersonList();
		//ArrayList<Person> persons = personList.getPersonList();
		String coupleName = request.getParameter("searchtext");
		StringBuffer result = new StringBuffer("");
		HttpSession session = request.getSession();
		CoupleSignUp user = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleInfo userCoupleInfo = user.getCoupleInfo();
		
		//Get Friend List and compare:
		
				ArrayList<CoupleSignUp> coupleFriends = friendsDAO.mytotalFriends(user);
				//ArrayList<CoupleInfo> coupleFriendsInfo = new ArrayList<CoupleInfo>();
				ArrayList<CoupleInfo> coupleInfoList1 = new ArrayList<CoupleInfo>();
				ArrayList<CoupleSignUp> pendingFriends = friendsDAO.requestSentPending(user);
				
				for(CoupleSignUp csu : coupleFriends){
					CoupleInfo cinfo = csu.getCoupleInfo();
					coupleInfoList1.add(cinfo);
				}
				
				for(CoupleSignUp csu2 : pendingFriends){
					CoupleInfo cinfo2 = csu2.getCoupleInfo();
					coupleInfoList1.add(cinfo2);
				}

		try {
			CoupleInfo couple = searchDAO.searchCoupleByCoupleName(coupleName);
			
			if(!(userCoupleInfo.getInfo_Id() == couple.getInfo_Id()))
			{
				boolean flag = false;
				System.out.println("Reached Here");
				for(CoupleInfo friend : coupleInfoList1)
				if(friend.getInfo_Id() == couple.getInfo_Id())
				{	flag = true;
					Person p1 = (Person)couple.getPersonList().get(0);
			Person p2 = (Person)couple.getPersonList().get(1);
				

			result = result.append("<li class=' clearfix'>"
					+ "<div class='thumbnail clearfix'>"+
					"<img src='/profileImages/"+searchDAO.getCoupleName(couple.getInfo_Id())+".jpg' class='img-circle col-md-2 clearfix'" +
					"onclick='return false' style='margin-right: 10px' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" />"
					+
					"<div class='caption'>"+
					"<form action='profileViewFriend' method='get'><input type='hidden' name='viewCoupleName' value='"+searchDAO.getCoupleName(friend.getInfo_Id())+"'/> "+
					"<button type='submit' "+
					"class='btn btn-primary icon  pull-right view-profile-btn'>View Profile</button></form>"
					+ "<a  class='btn btn-success icon  pull-right disabled'>Friend added</a>"
					+"<h4>"
					+"<a >"+searchDAO.getCoupleName(couple.getInfo_Id())+"</a>"
					+"</h4>"+
					"<b>Couple Info: </b><span" +
					"class='coupleName couple-info'> <span class='person1-age'>" +
					p1.getAge()+"</span> years old <span class='person1-sex'>"+ p1.getSex()+"</span> <span"
					+"class='&'> & </span> <span class='person2-age'>"+ p2.getAge() +"</span>"+
					"years old <span class='person2-sex'>"+ p2.getSex()+"</span>"+
					"</span> <br /> <span class='coupleName location'><strong>Current"+
					"Location:</strong><span class='coupleName location'>"+ couple.getLocation()+"</span><br />"+
					"<b> What are we looking for: </b><span class='username story'> "+couple.getLookingfor()+"</div></li>");
					break;
				}
				
				if(flag==false)
				{
					Person p1 = (Person)couple.getPersonList().get(0);
					Person p2 = (Person)couple.getPersonList().get(1);
						

					result = result.append("<li class=' clearfix'>"
							+ "<div class='thumbnail clearfix'>"+
							"<img src='/profileImages/"+searchDAO.getCoupleName(couple.getInfo_Id())+".jpg' class='img-circle col-md-2 clearfix'" +
							"onclick='return false' style='margin-right: 10px' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" />"
							+
							"<div class='caption'>"+
							"<form action='profileView' method='get'><input type='hidden' name='viewCoupleName' value='"+searchDAO.getCoupleName(couple.getInfo_Id())+"'/> "+
							"<button type='submit' "+
							"class='btn btn-primary icon  pull-right view-profile-btn'>View Profile</button></form>"
							+ "<a  class='btn btn-success icon  pull-right add-friend-btn'>Add Friend</a>"
							+"<h4>"
							+"<a >"+searchDAO.getCoupleName(couple.getInfo_Id())+"</a>"
							+"</h4>"+
							"<b>Couple Info: </b><span" +
							"class='coupleName couple-info'> <span class='person1-age'>" +
							p1.getAge()+"</span> years old <span class='person1-sex'>"+ p1.getSex()+"</span> <span"
							+"class='&'> & </span> <span class='person2-age'>"+ p2.getAge() +"</span>"+
							"years old <span class='person2-sex'>"+ p2.getSex()+"</span>"+
							"</span> <br /> <span class='coupleName location'><strong>Current"+
							"Location:</strong><span class='coupleName location'>"+ couple.getLocation()+"</span><br />"+
							"<b> What are we looking for: </b><span class='username story'> "+couple.getLookingfor()+"</div></li>");
				}
				

			}







		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error is: "+ e);
			e.printStackTrace();
		}

		return  result.toString();
	}


	@RequestMapping(value = "/searchByCoupleAge", method = RequestMethod.GET, produces="application/text")
	public  @ResponseBody String searchCoupleByCoupleAge(HttpServletRequest request, HttpServletResponse response) {

		//PersonList personList = new PersonList();
		//ArrayList<Person> persons = personList.getPersonList();
		int minAge = Integer.parseInt(request.getParameter("minAge"));
		int maxAge = Integer.parseInt(request.getParameter("maxAge"));
		StringBuffer result = new StringBuffer("");
		ArrayList<CoupleInfo> coupleList = new ArrayList<CoupleInfo>();
		HttpSession session = request.getSession();
		CoupleSignUp user = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleInfo userCoupleInfo = user.getCoupleInfo();
		
		//Get Friend List and compare:
		
				ArrayList<CoupleSignUp> coupleFriends = friendsDAO.mytotalFriends(user);
				//ArrayList<CoupleInfo> coupleFriendsInfo = new ArrayList<CoupleInfo>();
				ArrayList<CoupleInfo> coupleInfoList1 = new ArrayList<CoupleInfo>();
				ArrayList<CoupleSignUp> pendingFriends = friendsDAO.requestSentPending(user);
				
				for(CoupleSignUp csu : coupleFriends){
					CoupleInfo cinfo = csu.getCoupleInfo();
					coupleInfoList1.add(cinfo);
				}
				for(CoupleSignUp csu2 : pendingFriends){
					CoupleInfo cinfo2 = csu2.getCoupleInfo();
					coupleInfoList1.add(cinfo2);
				}
				boolean flag = false;

		try {
			coupleList = searchDAO.searchCouplesByAge(minAge, maxAge);

			for(CoupleInfo couple : coupleList)
			{	
				if(!(userCoupleInfo.getInfo_Id() == couple.getInfo_Id()))
				{ flag = false;
				System.out.println("Reached Here");
				for(CoupleInfo friend : coupleInfoList1)
				if(friend.getInfo_Id() == couple.getInfo_Id())
				{	flag = true;
					Person p1 = (Person)couple.getPersonList().get(0);
			Person p2 = (Person)couple.getPersonList().get(1);
				

			result = result.append("<li class=' clearfix'>"
					+ "<div class='thumbnail clearfix'>"+
					"<img src='/profileImages/"+searchDAO.getCoupleName(couple.getInfo_Id())+".jpg' class='img-circle col-md-2 clearfix'" +
					"onclick='return false' style='margin-right: 10px' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" />"
					+
					"<div class='caption'>"+
					"<form action='profileViewFriend' method='get'><input type='hidden' name='viewCoupleName' value='"+searchDAO.getCoupleName(friend.getInfo_Id())+"'/> "+
					"<button type='submit' "+
					"class='btn btn-primary icon  pull-right view-profile-btn'>View Profile</button></form>"
					+ "<a  class='btn btn-success icon  pull-right add-friend-btn disabled'>Friend added</a>"
					+"<h4>"
					+"<a >"+searchDAO.getCoupleName(couple.getInfo_Id())+"</a>"
					+"</h4>"+
					"<b>Couple Info: </b><span" +
					"class='coupleName couple-info'> <span class='person1-age'>" +
					p1.getAge()+"</span> years old <span class='person1-sex'>"+ p1.getSex()+"</span> <span"
					+"class='&'> & </span> <span class='person2-age'>"+ p2.getAge() +"</span>"+
					"years old <span class='person2-sex'>"+ p2.getSex()+"</span>"+
					"</span> <br /> <span class='coupleName location'><strong>Current"+
					"Location:</strong><span class='coupleName location'>"+ couple.getLocation()+"</span><br />"+
					"<b> What are we looking for: </b><span class='username story'> "+couple.getLookingfor()+"</div></li>");
					break;
				}
				
				if(flag==false)
				{
					Person p1 = (Person)couple.getPersonList().get(0);
					Person p2 = (Person)couple.getPersonList().get(1);
						

					result = result.append("<li class=' clearfix'>"
							+ "<div class='thumbnail clearfix'>"+
							"<img src='/profileImages/"+searchDAO.getCoupleName(couple.getInfo_Id())+".jpg' class='img-circle col-md-2 clearfix'" +
							"onclick='return false' style='margin-right: 10px' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" />"
							+
							"<div class='caption'>"+
							"<form action='profileView' method='get'><input type='hidden' name='viewCoupleName' value='"+searchDAO.getCoupleName(couple.getInfo_Id())+"'/> "+
							"<button type='submit' "+
							"class='btn btn-primary icon  pull-right view-profile-btn'>View Profile</button></form>"
							+ "<a  class='btn btn-success icon  pull-right add-friend-btn'>Add Friend</a>"
							+"<h4>"
							+"<a >"+searchDAO.getCoupleName(couple.getInfo_Id())+"</a>"
							+"</h4>"+
							"<b>Couple Info: </b><span" +
							"class='coupleName couple-info'> <span class='person1-age'>" +
							p1.getAge()+"</span> years old <span class='person1-sex'>"+ p1.getSex()+"</span> <span"
							+"class='&'> & </span> <span class='person2-age'>"+ p2.getAge() +"</span>"+
							"years old <span class='person2-sex'>"+ p2.getSex()+"</span>"+
							"</span> <br /> <span class='coupleName location'><strong>Current"+
							"Location:</strong><span class='coupleName location'>"+ couple.getLocation()+"</span><br />"+
							"<b> What are we looking for: </b><span class='username story'> "+couple.getLookingfor()+"</div></li>");
				}
				}
				}
			}

		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error is: "+ e);
			e.printStackTrace();
		}
		return  result.toString();
	}


	@RequestMapping(value = "/searchByCoupleActivity", method = RequestMethod.GET, produces="application/text")
	public  @ResponseBody String searchCoupleActivity(HttpServletRequest request, HttpServletResponse response) {

		//PersonList personList = new PersonList();
		//ArrayList<Person> persons = personList.getPersonList();
		String activity = request.getParameter("searchText");

		StringBuffer result = new StringBuffer("");
		ArrayList<CoupleInfo> coupleList = new ArrayList<CoupleInfo>();
		HttpSession session = request.getSession();
		CoupleSignUp user = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleInfo userCoupleInfo = user.getCoupleInfo();
		
		
		//Get Friend List and compare:
		
		ArrayList<CoupleSignUp> coupleFriends = friendsDAO.mytotalFriends(user);
		//ArrayList<CoupleInfo> coupleFriendsInfo = new ArrayList<CoupleInfo>();
		ArrayList<CoupleInfo> coupleInfoList1 = new ArrayList<CoupleInfo>();
		ArrayList<CoupleSignUp> pendingFriends = friendsDAO.requestSentPending(user);
		
		for(CoupleSignUp csu : coupleFriends){
			CoupleInfo cinfo = csu.getCoupleInfo();
			coupleInfoList1.add(cinfo);
		}
		for(CoupleSignUp csu2 : pendingFriends){
			CoupleInfo cinfo2 = csu2.getCoupleInfo();
			coupleInfoList1.add(cinfo2);
		}
		
		boolean flag = false;


		try {
			coupleList = searchDAO.searchCouplesByActivity(activity);

			for(CoupleInfo couple : coupleList)
			{	
				if(!(userCoupleInfo.getInfo_Id() == couple.getInfo_Id()))
				{flag = false;
				System.out.println("Reached Here");
				for(CoupleInfo friend : coupleInfoList1)
				if(friend.getInfo_Id() == couple.getInfo_Id())
				{	flag = true;
					Person p1 = (Person)couple.getPersonList().get(0);
			Person p2 = (Person)couple.getPersonList().get(1);
				

			result = result.append("<li class=' clearfix'>"
					+ "<div class='thumbnail clearfix'>"+
					"<img src='/profileImages/"+searchDAO.getCoupleName(couple.getInfo_Id())+".jpg' class='img-circle col-md-2 clearfix'" +
					"onclick='return false' style='margin-right: 10px' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" />"
					+
					"<div class='caption'>"+
					"<form action='profileViewFriend' method='get'><input type='hidden' name='viewCoupleName' value='"+searchDAO.getCoupleName(friend.getInfo_Id())+"'/> "+
					"<button type='submit' "+
					"class='btn btn-primary icon  pull-right view-profile-btn'>View Profile</button></form>"
					+ "<a  class='btn btn-success icon  pull-right add-friend-btn disabled'>Friend added</a>"
					+"<h4>"
					+"<a >"+searchDAO.getCoupleName(couple.getInfo_Id())+"</a>"
					+"</h4>"+
					"<b>Couple Info: </b><span" +
					"class='coupleName couple-info'> <span class='person1-age'>" +
					p1.getAge()+"</span> years old <span class='person1-sex'>"+ p1.getSex()+"</span> <span"
					+"class='&'> & </span> <span class='person2-age'>"+ p2.getAge() +"</span>"+
					"years old <span class='person2-sex'>"+ p2.getSex()+"</span>"+
					"</span> <br /> <span class='coupleName location'><strong>Current"+
					"Location:</strong><span class='coupleName location'>"+ couple.getLocation()+"</span><br />"+
					"<b> What are we looking for: </b><span class='username story'> "+couple.getLookingfor()+"</div></li>");
					break;
				}
				
				if(flag==false)
				{
					Person p1 = (Person)couple.getPersonList().get(0);
					Person p2 = (Person)couple.getPersonList().get(1);
						

					result = result.append("<li class=' clearfix'>"
							+ "<div class='thumbnail clearfix'>"+
							"<img src='/profileImages/"+searchDAO.getCoupleName(couple.getInfo_Id())+".jpg' class='img-circle col-md-2 clearfix'" +
							"onclick='return false' style='margin-right: 10px' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" />"
							+
							"<div class='caption'>"+
							"<form action='profileView' method='get'><input type='hidden' name='viewCoupleName' value='"+searchDAO.getCoupleName(couple.getInfo_Id())+"'/> "+
							"<button type='submit' "+
							"class='btn btn-primary icon  pull-right view-profile-btn'>View Profile</button></form>"
							+ "<a  class='btn btn-success icon  pull-right add-friend-btn'>Add Friend</a>"
							+"<h4>"
							+"<a >"+searchDAO.getCoupleName(couple.getInfo_Id())+"</a>"
							+"</h4>"+
							"<b>Couple Info: </b><span" +
							"class='coupleName couple-info'> <span class='person1-age'>" +
							p1.getAge()+"</span> years old <span class='person1-sex'>"+ p1.getSex()+"</span> <span"
							+"class='&'> & </span> <span class='person2-age'>"+ p2.getAge() +"</span>"+
							"years old <span class='person2-sex'>"+ p2.getSex()+"</span>"+
							"</span> <br /> <span class='coupleName location'><strong>Current"+
							"Location:</strong><span class='coupleName location'>"+ couple.getLocation()+"</span><br />"+
							"<b> What are we looking for: </b><span class='username story'> "+couple.getLookingfor()+"</div></li>");
				}
				}
				}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error is: "+ e);
			e.printStackTrace();
		}
		return  result.toString();
	}
}
