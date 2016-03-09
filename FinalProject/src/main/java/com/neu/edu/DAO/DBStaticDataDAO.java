package com.neu.edu.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.neu.edu.Model.Activities;

import freemarker.core.ReturnInstruction.Return;

public class DBStaticDataDAO extends DAO {


	@SuppressWarnings("unchecked")
	public ArrayList<Activities> gettingActivities()throws HibernateException{
		ArrayList<Activities> activityList = null;
		try {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery("from Activities");
			activityList = new ArrayList<Activities>();
			
			activityList = (ArrayList<Activities>) query.list();
		
			session.close();
			return activityList;
		} catch (HibernateException e) {
			System.err.println("exception is " + e);
		}
		return activityList;
		
	}
	

}