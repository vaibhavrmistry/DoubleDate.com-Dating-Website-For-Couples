package com.neu.edu.DAO;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neu.edu.HomeController;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.CoupleRememberToken;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.FriendZone;
import com.neu.edu.Model.Role;
import com.neu.edu.Model.UserRole;
import com.neu.edu.Model.KeyGen.KeyGenerator;

public class CoupleSignUpDAO extends DAO {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	public CoupleSignUp checkLogin(String coupleName, String password) throws Exception{
		CoupleSignUp csu = null;

		try {
			Session session = getSession();
			Query query = session.createQuery("from CoupleSignUp where coupleName =:username and password =:password");
			query.setString("username", coupleName);
			query.setString("password", password);
			csu = (CoupleSignUp) query.uniqueResult();
			session.close();

			return csu;
		} catch (HibernateException e) {
			throw new Exception("showing exception on fetching user as" + e);
		}
	}


	public String AddSignUpCouple(CoupleSignUp csu){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		int roleId = 2;
		Query query = session.createQuery("from Role where id =:roleId");
		query.setInteger("roleId", roleId);
		Role role = (Role) query.uniqueResult();
		csu.setRole(role);
		session.save(csu);
		tx.commit();
		session.close();
		logger.info("Couple Saved successfully" + csu);
		return "success";
	}

	public CoupleInfo getUserData(String coupleName){
		Session session = getSession();
		Query query= session.createQuery("from CoupleSignUp where coupleName =:coupleName1");
		query.setString("coupleName1", coupleName);
		CoupleSignUp csu = (CoupleSignUp) query.uniqueResult();

		CoupleInfo coupleInfo = csu.getCoupleInfo();
		if(coupleInfo == null){
			session.close();
			return coupleInfo;
		} else {
			session.close();
			return coupleInfo;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CoupleSignUp> getCoupleInfo(ArrayList<FriendZone> friendList,CoupleSignUp fromUser1){
		ArrayList<CoupleSignUp> sentPendingcoupleList = new ArrayList<CoupleSignUp>();
		ArrayList<CoupleSignUp> fullList = new ArrayList<CoupleSignUp>();
		Session session = getSession();
		Query query = session.createQuery("from CoupleSignUp");
		fullList = (ArrayList<CoupleSignUp>) query.list();

		int lengthFriend = friendList.size();
		int lengthCouple = fullList.size();
		for(int i=0; i<lengthFriend; i++){
			for(int j=0; j<lengthCouple; j++){
				if(friendList.get(i).getToUser() != fromUser1.getCoupleID())
				{if(friendList.get(i).getToUser() == fullList.get(j).getCoupleID()){
					sentPendingcoupleList.add(fullList.get(j));
				}
				}
				else
				{
					if(friendList.get(i).getFromUser() == fullList.get(j).getCoupleID()){
						sentPendingcoupleList.add(fullList.get(j));

					}
				}
			}
		}
		session.close();
		return sentPendingcoupleList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CoupleSignUp> getCoupleInfoFrom(ArrayList<FriendZone> friendList){
		ArrayList<CoupleSignUp> sentPendingcoupleList = new ArrayList<CoupleSignUp>();
		ArrayList<CoupleSignUp> fullList = new ArrayList<CoupleSignUp>();
		Session session = getSession();
		Query query = session.createQuery("from CoupleSignUp");
		fullList = (ArrayList<CoupleSignUp>) query.list();

		int lengthFriend = friendList.size();
		int lengthCouple = fullList.size();
		for(int i=0; i<lengthFriend; i++){
			for(int j=0; j<lengthCouple; j++){
				if(friendList.get(i).getFromUser() == fullList.get(j).getCoupleID()){
					sentPendingcoupleList.add(fullList.get(j));
				}
			}
		}
		session.close();
		return sentPendingcoupleList;
	}

	//	public void createCookies(CoupleSignUp csu, HttpServletRequest request, HttpServletResponse response, String remember){
	//		String key = KeyGenerator.genKey();
	//		Session session = getSession();
	//		Transaction tx= session.beginTransaction();
	//		csu.setRemember(remember);
	//		CoupleRememberToken crt = new CoupleRememberToken();
	//		crt.setToken_No(key);
	//		crt.setCoupleSignUp(csu);
	//		session.update(csu);
	//		session.save(crt);
	//		tx.commit();
	//		session.close();
	//
	//		// Now creating the cookie for the same to add remember me and token
	//		Cookie cookie = new Cookie("key", key);
	//		cookie.setMaxAge(1*24*60*60);
	//		response.addCookie(cookie);
	//	}


	public boolean checkUserName(String coupleName){
		Session session = getSession();
		Query query= session.createQuery("from CoupleSignUp where coupleName =:coupleName1");
		query.setString("coupleName1", coupleName);
		CoupleSignUp csu = (CoupleSignUp) query.uniqueResult();

		if(csu == null)
		{
			session.close();
			return true;
		}
		else
		{
			session.close();
			return false;
		}


	}


	public CoupleSignUp getSignUpUsingName(String coupleName){
		Session session = getSession();
		Query query= session.createQuery("from CoupleSignUp where coupleName =:coupleName1");
		query.setString("coupleName1", coupleName);
		CoupleSignUp csu = (CoupleSignUp) query.uniqueResult();
		session.close();
		return csu;


	}

}
