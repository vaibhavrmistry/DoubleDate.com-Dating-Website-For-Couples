package com.neu.edu;

import java.util.ArrayList;

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

import com.neu.edu.DAO.CoupleInfoDAO;
import com.neu.edu.DAO.CoupleSignUpDAO;
import com.neu.edu.DAO.FriendsDAO;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.FriendZone;


@Controller
public class FriendController {


	@Autowired
	private FriendsDAO friendsDAO;
	@Autowired
	private CoupleInfoDAO coupleInfoDAO;
	@Autowired
	private CoupleSignUpDAO coupleSignUpDAO;



	@RequestMapping(value = "/addFriendRequest", method = RequestMethod.POST, produces="application/text")
	public @ResponseBody String addFriends(Model model, @RequestParam("requestTo") String viewCoupleName,
			HttpServletRequest request, HttpServletResponse response){
		System.out.println("the view user name is " + viewCoupleName);
		HttpSession session = request.getSession();
		CoupleSignUp fromUser = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleSignUp toUser = coupleInfoDAO.fetchViewCouple(viewCoupleName);

		String success = friendsDAO.addFriend(fromUser, toUser);
		model.addAttribute("success", success);
		return "Success";
	}

	//all accepted friend list of user
	@RequestMapping(value = "/searchAllAccepted", method = RequestMethod.GET)
	public String searchAllAcceptedFriends(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		CoupleSignUp fromUser = (CoupleSignUp) session.getAttribute("coupleSU");
		ArrayList<CoupleSignUp> coupleFriends = friendsDAO.mytotalFriends(fromUser);
		
		model.addAttribute("acceptedFriends", coupleFriends);
		model.addAttribute("coupleSU",fromUser );
		return "friendList";
	}
	
	// allfriendlist for a user when clicking on the all fried tab - using ajax code
	
	@RequestMapping(value = "/searchAllAcceptedByTab", method = RequestMethod.GET, produces="application/text")
	public String searchAllAcceptedFriendsByTab(Model model, HttpServletRequest request){
		HttpSession session = request.getSession();
		CoupleSignUp fromUser = (CoupleSignUp) session.getAttribute("coupleSU");
		ArrayList<CoupleSignUp> coupleFriends = friendsDAO.mytotalFriends(fromUser);
		
		model.addAttribute("acceptedFriends", coupleFriends);
		
		return "friendList";
	}

	// request sent by user in pending status
	@RequestMapping(value = "/pendingSendByUser", method = RequestMethod.GET, produces="application/text")
	public @ResponseBody String pendingRequestByMe(Model model, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		CoupleSignUp fromUser = (CoupleSignUp) session.getAttribute("coupleSU");
		ArrayList<CoupleSignUp> fzone = friendsDAO.requestSentPending(fromUser);

		StringBuffer result = new StringBuffer("");
		int counter = 0;
		for(CoupleSignUp coupleSignUp : fzone)
		{	
			
			result = result.append("<li class='clearfix'><div class='thumbnail clearfix'>"+
					"<img src='/profileImages/"+coupleSignUp.getCoupleName()+".jpg' alt='ALT NAME' class='pull-left  img-circle' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" style='margin-right: 10px; width: 150px; height: 150px;'>"+
					"<div class='caption'>"+
					"<h4><a href='#'>"+coupleSignUp.getCoupleName()+"</a></h4><small><b>Couple Info: </b><span class='coupleName couple-info'> <span class='person1-age'> "+coupleSignUp.getCoupleInfo().getPersonList().get(0).getAge()+"</span> years old <span "+
					"class='person1-sex'>"+ coupleSignUp.getCoupleInfo().getPersonList().get(0).getSex()+"</span> <span class='&'> & </span> <span class='person2-age'>"+coupleSignUp.getCoupleInfo().getPersonList().get(1).getAge()+"</span> years old <span class='person2-sex'>"+ coupleSignUp.getCoupleInfo().getPersonList().get(0).getSex()+"</span>"+
					"</span> <br /> <span class='coupleName location'><strong>Current Location:</strong><span class='coupleName location'>"+coupleSignUp.getCoupleInfo().getLocation()+"</span><br /> <b>What are we looking for: </b><span	class='username story'>"+coupleSignUp.getCoupleInfo().getLookingfor()+"</small>	</div></div></li>");

		}
		//model.addAttribute("pendingReqCount", counter);
		return result.toString();
	}


	// pending request sent by others to the user
	@RequestMapping(value = "/pendingReceivedByUser", method = RequestMethod.GET, produces="application/text")
	public @ResponseBody String pendingRequestForMe(Model model, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		CoupleSignUp toUser = (CoupleSignUp) session.getAttribute("coupleSU");
		ArrayList<CoupleSignUp> fzone = friendsDAO.requestReceivedPending(toUser);

		StringBuffer result = new StringBuffer("");
		int counter = 0;
		for(CoupleSignUp coupleSignUp : fzone)
		{	
			counter++;
			result = result.append("<li class='clearfix'><div class='thumbnail clearfix'>"+
					"<img src='/profileImages/"+coupleSignUp.getCoupleName()+".jpg' alt='ALT NAME' class='pull-left  img-circle' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\" style='margin-right: 10px; width: 150px; height: 150px;'>"+
					"<div class='caption'><a  class='btn btn-danger icon  pull-right decline-btn'>Decline</a> <a  class='btn btn-success icon  pull-right accept-btn'>Accept</a>"+
					"<h4><a href='#'>"+coupleSignUp.getCoupleName()+"</a></h4><small><b>Couple Info: </b><span class='coupleName couple-info'> <span class='person1-age'> "+coupleSignUp.getCoupleInfo().getPersonList().get(0).getAge()+"</span> years old <span "+
					"class='person1-sex'>"+ coupleSignUp.getCoupleInfo().getPersonList().get(0).getSex()+"</span> <span class='&'> & </span> <span class='person2-age'>"+coupleSignUp.getCoupleInfo().getPersonList().get(1).getAge()+"</span> years old <span class='person2-sex'>"+ coupleSignUp.getCoupleInfo().getPersonList().get(1).getSex()+"</span"+
					"</span> <br /> <span class='coupleName location'><strong>Current Location:</strong><span class='coupleName location'>"+coupleSignUp.getCoupleInfo().getLocation()+"</span><br /> <b>What are we looking for: </b><span	class='username story'>"+coupleSignUp.getCoupleInfo().getLookingfor()+"</small>	</div></div></li>");
					
		}
		//model.addAttribute("friendRequestCount", counter);
		return result.toString();
	}

	// Accepting the pending request

	@RequestMapping(value = "/acceptingPendingRequest", method = RequestMethod.GET, produces="application/text" )
	public @ResponseBody String acceptingPendingRequest(Model model, HttpServletRequest request, @RequestParam("coupleToAccept") String coupleToAccept){
		HttpSession session = request.getSession();
		CoupleSignUp toUser = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleSignUp fromUser = coupleInfoDAO.fetchViewCouple(coupleToAccept);
		String success = friendsDAO.acceptFriendRequest(fromUser, toUser);
		return "success";
	}


	@RequestMapping(value = "/decliningPendingRequest", method = RequestMethod.GET, produces="application/text")
	public  @ResponseBody String decliningPendingRequest(Model model, HttpServletRequest request, @RequestParam("coupleToDecline") String coupleToecline){
		HttpSession session = request.getSession();
		CoupleSignUp toUser = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleSignUp fromUser = coupleInfoDAO.fetchViewCouple(coupleToecline);
		String success = friendsDAO.declineFriendRequest(fromUser, toUser);
		return success;
	}

	@RequestMapping(value = "/unfriend", method = RequestMethod.GET, produces="application/text")
	public @ResponseBody String unfriendAFriend(Model model, HttpServletRequest request, @RequestParam("coupleToUnfriend") String coupleToUnfriend){
		HttpSession session = request.getSession();
		CoupleSignUp toUser = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleSignUp fromUser = coupleInfoDAO.fetchViewCouple(coupleToUnfriend);
		String success = friendsDAO.unfriendaFriend(fromUser, toUser);
		return success;
	}

}
