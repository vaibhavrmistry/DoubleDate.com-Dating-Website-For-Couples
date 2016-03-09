package com.neu.edu;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.runtime.internal.PerObjectMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.ui.Model;

import com.neu.edu.DAO.HibernateUtil;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Inbox;
import com.neu.edu.Model.Person;
import com.neu.edu.Model.Role;
import com.neu.edu.Model.KeyGen.KeyGenerator;


public class AppTest {

	public static void main(String[] args) {

		//Session session  = HibernateUtil.getSessionFactory().openSession();

		//		InboxController ic = new InboxController();
		//		ic.populateMessages(chatWith, request, response)


		//		Transaction tx = session.beginTransaction();
		//
		//		CoupleSignUp csu = new CoupleSignUp();
		//		CoupleSignUp csu1 = new CoupleSignUp();
		//		csu.setCoupleName("java1");
		//		csu.setEmailId("java1@java1.com");
		//		csu.setPassword("java1");
		//
		//		csu1.setCoupleName("java2");
		//		csu1.setEmailId("java2@java2.com");
		//		csu1.setPassword("java2");
		//
		//		Inbox inbox = new Inbox();
		//		inbox.setFromUser(csu);
		//		inbox.setToUser(csu1);
		//		inbox.setMessage("Hi man how are you");
		//
		//		session.save(csu);
		//		session.save(csu1);
		//		session.save(inbox);
		//		tx.commit();

		KeyGenerator kg = new KeyGenerator();
		String key = 	kg.genKey();
		System.out.println("the key is " + key);
	}
}
