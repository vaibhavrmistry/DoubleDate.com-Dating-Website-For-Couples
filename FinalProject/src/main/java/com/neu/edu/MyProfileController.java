package com.neu.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.edu.DAO.CoupleInfoDAO;

public class MyProfileController {

	@Autowired
	private CoupleInfoDAO coupleInfoDao;


	@RequestMapping(value = "/profilePage", method = RequestMethod.GET)
	public String profilePage(Model model) {
		//CoupleSignUp csu = new CoupleSignUp();
		//model.addAttribute("coupleSignUp", csu);
		return "Dashboard";
	}
}
