package com.neu.edu;


import java.util.ArrayList;
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

import com.neu.edu.DAO.CoupleInfoDAO;
import com.neu.edu.DAO.CoupleSignUpDAO;
import com.neu.edu.DAO.InboxDAO;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Inbox;

@Controller
public class InboxController {

	@Autowired
	private InboxDAO inboxDAO;

	@Autowired
	private CoupleSignUpDAO coupleSignUpDAO;

	@Autowired
	private CoupleInfoDAO coupleInfoDAO;



	@RequestMapping(value="/addMessages", method=RequestMethod.POST)
	public @ResponseBody String addMessage(Model model, @RequestParam("coupleName") String MsgSendToCouple,
			@RequestParam("message") String message,	HttpServletRequest request, HttpServletResponse response) 
					throws Exception{

		HttpSession session = request.getSession();
		CoupleSignUp fromCouple = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleSignUp toCoupleSignUp = coupleInfoDAO.fetchViewCouple(MsgSendToCouple);
		inboxDAO.addMessage(fromCouple, toCoupleSignUp, message);
		return "success";
	}


	@RequestMapping(value="/populateMessages", method=RequestMethod.GET, produces="application/text")
	public @ResponseBody String populateMessages(Model model, @RequestParam("chatWith") String chatWith, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		System.out.println("Chat With: "+chatWith);
		CoupleSignUp fromCouple = (CoupleSignUp) session.getAttribute("coupleSU");
		CoupleSignUp toCouple = coupleInfoDAO.fetchViewCouple(chatWith);
		System.out.println("value of couple is "+ toCouple.getCoupleName());
		ArrayList<Inbox> finalMessages = inboxDAO.fetchMessages(fromCouple, toCouple);
		
		//Display Results:
		StringBuffer result = new StringBuffer("");
		for(Inbox messageInfo :finalMessages)
		{
			if(messageInfo.getFromUser().getCoupleName().equalsIgnoreCase(fromCouple.getCoupleName()))
			{result = result.append("<li class='media'><div class='media-body col-md-8 bg-info pull-right'><div class='media'>"+
									"<a class='pull-right'> <img	class='media-object img-circle ' style='max-height: 50px;' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\"  src='/profileImages/"+messageInfo.getFromUser().getCoupleName()+".jpg' />"
									+"</a> <div class='media-body'>"+messageInfo.getMessage()+" <br /> <small class='text-muted'>"+messageInfo.getFromUser().getCoupleName()+" | "+messageInfo.getDateOfMsg().toString()+"</small><hr /></div></div></div></li> ");
			}
			else 
			{
				result = result.append("<li class='media'><div class='media-body col-md-8 bg-success pull-left'><div class='media'>"+
						"<a class='pull-left'> <img	class='media-object img-circle ' style='max-height: 50px;' onerror=\"this.src='resources//img/Dashboard/defaultProfile.jpg';\"  src='/profileImages/"+messageInfo.getFromUser().getCoupleName()+".jpg' />"
						+"</a> <div class='media-body'>"+messageInfo.getMessage()+" <br /> <small class='text-muted'>"+messageInfo.getFromUser().getCoupleName()+" | "+messageInfo.getDateOfMsg().toString()+"</small><hr /></div></div></div></li> ");
				
			}
		}
		
		
		//model.addAttribute("finalMessages", finalMessages);
		return result.toString();
	}



	@RequestMapping(value="/findAllChatters", method=RequestMethod.GET)
	public String findAllChatters(Model model, HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		CoupleSignUp mainCouple = (CoupleSignUp) session.getAttribute("coupleSU");
		String username = mainCouple.getCoupleName();
		//	ArrayList<Inbox> connectionList = inboxDAO.connectionList(mainCouple);
		ArrayList<String> uniqueUsers = inboxDAO.connectionList(mainCouple, username);
		model.addAttribute("loginCouple",username);
		model.addAttribute("connectionList", uniqueUsers);
		return "messages";
	}


}



