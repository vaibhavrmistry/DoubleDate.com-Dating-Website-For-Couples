package com.neu.edu.DAO;

import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Inbox;

public class InboxDAO extends DAO {

	public void addMessage(CoupleSignUp fromCoupleObj, CoupleSignUp toCoupleObj, String message) throws Exception{
		try {

			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction tx = session.beginTransaction();
			Inbox inbox = new Inbox();
			inbox.setFromUser(fromCoupleObj);
			inbox.setToUser(toCoupleObj);
			inbox.setMessage(message);
			session.save(inbox);
			tx.commit();
			session.close();
		} catch (HibernateException e) {

			System.err.println("error on saving message in table " + e);
		}
	}


	@SuppressWarnings("unchecked")
	public ArrayList<Inbox>  fetchMessages(CoupleSignUp fromCouple, CoupleSignUp toCouple){
		int fromCoupleID = fromCouple.getCoupleID();
		int toCoupleID = toCouple.getCoupleID();
		ArrayList<Inbox> messageList= new ArrayList<Inbox>();
		//	 Searching the messages from the database for the defined couple
		Session session = getSession();
		Query query = session.createQuery("from Inbox where (fromUser =:fromCouple and toUser =:toCouple)"
				+ " or (fromUser =:toCouple and toUser =:fromCouple) order by dateOfMsg ASC");
		query.setInteger("fromCouple", fromCoupleID);
		query.setInteger("toCouple", toCoupleID);
		messageList = (ArrayList<Inbox>) query.list();
		session.close();
		return messageList;
	}


	@SuppressWarnings("unchecked")
	public ArrayList<String> connectionList(CoupleSignUp mainCouple, String username){
		
		Session session = getSession();
		
		ArrayList<Inbox> list1 = new ArrayList<Inbox>();
		Query query = session.createQuery("from Inbox where fromUser=:fuser OR toUser=:fuser order by dateOfMsg DESC");
		query.setInteger("fuser", mainCouple.getCoupleID() );
		
		ArrayList<String> uniqueUsers = new ArrayList<String>();
		list1 = (ArrayList<Inbox>) query.list();
		
		for(Inbox inbox : list1)
		{	
			
			if(!uniqueUsers.contains(inbox.getFromUser().getCoupleName()) && !(inbox.getFromUser().getCoupleName().equalsIgnoreCase(username)))
			{
				uniqueUsers.add(inbox.getFromUser().getCoupleName());
			}
			if(!uniqueUsers.contains(inbox.getToUser().getCoupleName()) && !(inbox.getToUser().getCoupleName().equalsIgnoreCase(username)))
			{
				uniqueUsers.add(inbox.getToUser().getCoupleName());
			}
			
		}
		session.close();
		
		return uniqueUsers;
		
		
//		ArrayList<Inbox> list1 = new ArrayList<Inbox>();
//		ArrayList<Inbox> list2 = new ArrayList<Inbox>();
//		Session session = getSession();
//		Query query = session.createQuery("select distinct fromUser, distinct toUser from Inbox where fromUser =:fromUser order by dateOfMsg ASC");
//		query.setEntity("fromUser", mainCouple);
//		list1 = (ArrayList<Inbox>) query.list();
//		Query query1 = session.createQuery("select distinct toUser from Inbox where toUser =:toUser order by dateOfMsg ASC");
//		query1.setEntity("toUser", mainCouple);
//		System.out.println("Values of list 1 and list 2 are " + list1.size() + list2.size());
//		ArrayList<Inbox> mainList = getfinalValuesChat(list1, list2);
//		
//		session.close();
	
	}



//	public ArrayList<Inbox> getfinalValuesChat(ArrayList<Inbox> list1, ArrayList<Inbox> list2){
//		int length1 = list1.size();
//		int length2 = list2.size();
//
//		for(int i=0; i<length1; i++){
//			for(int j=0; j<length2; j++){
//				if(list1.get(i).getFromUser().equals(list2.get(j).getToUser()) &&
//						list1.get(i).getToUser().equals(list2.get(j).getFromUser())){
//					list2.remove(j);
//				}
//			}
//		}
//		int updatedLength = list2.size();
//		for(int k=0; k<updatedLength; k++){
//			list1.add(list2.get(k));
//		}
//		return list1;
//	}
}




