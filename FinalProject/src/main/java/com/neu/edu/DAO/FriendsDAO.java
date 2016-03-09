package com.neu.edu.DAO;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.FriendZone;

public class FriendsDAO extends DAO{

	CoupleSignUpDAO coupleSignUpDAO = new CoupleSignUpDAO();

	//-----------------------------------different way of doing from above method----------------

	public String addFriend(CoupleSignUp fromUser1, CoupleSignUp toUser1){
		int fromUser = fromUser1.getCoupleID();
		int toUser = toUser1.getCoupleID();
		FriendZone friendZone = new FriendZone();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		friendZone.setAccepted(false);
		friendZone.setUnfriend(false);
		friendZone.setFromUser(fromUser);
		friendZone.setToUser(toUser);
		session.save(friendZone);
		tx.commit();
		session.close();
		return "success";
	}

	@SuppressWarnings("unchecked")
	public ArrayList<CoupleSignUp> mytotalFriends(CoupleSignUp fromUser1){
		int fromUser = fromUser1.getCoupleID();
		ArrayList<FriendZone> totalFriendsList = new ArrayList<FriendZone>();
		ArrayList<FriendZone> myFriendList = new ArrayList<FriendZone>();
		Session session = getSession();
		Query query = session.createQuery("from FriendZone");
		totalFriendsList=  (ArrayList<FriendZone>) query.list();
		for (FriendZone friend : totalFriendsList){
			if((friend.getFromUser() == fromUser) && (friend.isAccepted() == true) &&
					(friend.isUnfriend() == false)   || (friend.getToUser()== fromUser) &&
					(friend.isAccepted() == true) && (friend.isUnfriend() == false)){
				myFriendList.add(friend);
			}
		}
		session.close();
		ArrayList<CoupleSignUp> finalCoupleFriends = coupleSignUpDAO.getCoupleInfo(myFriendList,fromUser1);	
		return finalCoupleFriends;
	}


	@SuppressWarnings("unchecked")
	public ArrayList<CoupleSignUp> requestSentPending(CoupleSignUp fromUser1){
		int fromUser = fromUser1.getCoupleID();

		ArrayList<FriendZone> totalFriendsList = new ArrayList<FriendZone>();
		ArrayList<FriendZone> sentPendingFriendList = new ArrayList<FriendZone>();
		Session session = getSession();
		Query query = session.createQuery("from FriendZone");
		totalFriendsList=  (ArrayList<FriendZone>) query.list();
		for (FriendZone friend : totalFriendsList){
			if(friend.getFromUser() == fromUser && friend.isAccepted() == false && friend.isUnfriend() == false){
				sentPendingFriendList.add(friend);
			}
		}
		session.close();
		ArrayList<CoupleSignUp> sentPendingCouplesReq = coupleSignUpDAO.getCoupleInfo(sentPendingFriendList,fromUser1);	
		return sentPendingCouplesReq;
	}


	@SuppressWarnings("unchecked")
	public ArrayList<CoupleSignUp> requestReceivedPending(CoupleSignUp toUser1){
		int toUser = toUser1.getCoupleID();
		ArrayList<FriendZone> totalFriendsList = new ArrayList<FriendZone>();
		ArrayList<FriendZone> receivedPendingFriendList = new ArrayList<FriendZone>();
		Session session = getSession();
		Query query = session.createQuery("from FriendZone");
		totalFriendsList=  (ArrayList<FriendZone>) query.list();
		for (FriendZone friend : totalFriendsList){
			if(friend.getToUser() == toUser && friend.isAccepted() == false){
				receivedPendingFriendList.add(friend);
			}
		}
		session.close();
		ArrayList<CoupleSignUp> receivedPendingCouplesReq = coupleSignUpDAO.getCoupleInfoFrom(receivedPendingFriendList);	
		return receivedPendingCouplesReq;
	}

	@SuppressWarnings("unchecked")
	public String acceptFriendRequest(CoupleSignUp fromUser1, CoupleSignUp toUser1){
		int fromUser = fromUser1.getCoupleID();
		int toUser = toUser1.getCoupleID();
		ArrayList<FriendZone> totalFriendsList = new ArrayList<FriendZone>();
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from FriendZone");
		totalFriendsList=  (ArrayList<FriendZone>) query.list();
		for (FriendZone friend : totalFriendsList){
			if(friend.getFromUser() == fromUser && friend.getToUser() == toUser && friend.isAccepted() == false && friend.isUnfriend() == false){
				friend.setAccepted(true);
				tx.commit();

			}
		}
		session.close();
		return "success";
	}


	@SuppressWarnings("unchecked")
	public String declineFriendRequest(CoupleSignUp fromUser1, CoupleSignUp toUser1){
		int fromUser = fromUser1.getCoupleID();
		int toUser = toUser1.getCoupleID();
		ArrayList<FriendZone> totalFriendsList = new ArrayList<FriendZone>();
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from FriendZone");
		totalFriendsList=  (ArrayList<FriendZone>) query.list();
		for (FriendZone friend : totalFriendsList){
			if(friend.getFromUser() == fromUser && friend.getToUser() == toUser && friend.isAccepted() == false && friend.isUnfriend() == false){
				session.delete(friend);
				tx.commit();
			}
		}
		session.close();
		return "success";
	}

	@SuppressWarnings("unchecked")
	public String unfriendaFriend(CoupleSignUp fromUser1, CoupleSignUp toUser1){
		int fromUser = fromUser1.getCoupleID();
		int toUser = toUser1.getCoupleID();
		ArrayList<FriendZone> totalFriendsList = new ArrayList<FriendZone>();
		Session session = getSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from FriendZone");
		totalFriendsList=  (ArrayList<FriendZone>) query.list();
		for (FriendZone friend : totalFriendsList){
			if((friend.getFromUser() == fromUser && friend.getToUser() == toUser && friend.isAccepted() == true && friend.isUnfriend() == false)||
					(friend.getToUser() == fromUser && friend.getFromUser() == toUser && friend.isAccepted() == true && friend.isUnfriend() == false)){
				friend.setUnfriend(true);
				tx.commit();
			}
		}
		session.close();
		return "success";
	}
}