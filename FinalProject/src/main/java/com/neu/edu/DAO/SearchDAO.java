package com.neu.edu.DAO;

import java.util.ArrayList;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.neu.edu.Model.Activities;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.Person;

public class SearchDAO extends DAO{

	@SuppressWarnings("unchecked")
	public ArrayList<CoupleInfo> searchCouplesByLocation(String location, int resultId) throws Exception
	{	
		int id = 0;
		if(resultId != 0)
		{
			id = resultId;
		}
		
		try {
			Session session = getSession();
			Query query = session.createQuery("from CoupleInfo where location =:location ").setFirstResult(id).setMaxResults(3+id);
			query.setString("location", location);
			//query.setInteger("infoId", id);

			
			ArrayList<CoupleInfo> results = (ArrayList<CoupleInfo>) query.list();

			session.close();
			return results;
		} catch (HibernateException e) {
			throw new Exception("showing exception on fetching user as" + e);
		}

	}


	public String getCoupleName (int couple_id) throws Exception
	{	

		try {
			Session session = getSession();
			Query query = session.createQuery("from CoupleSignUp where info_Id_FK =:id");
			query.setInteger("id", couple_id);

			CoupleSignUp csu = (CoupleSignUp) query.uniqueResult();
			String coupleName = csu.getCoupleName();


			session.close();
			return coupleName;
		} catch (HibernateException e) {
			throw new Exception("showing exception on fetching user as" + e);
		}

	}


	public CoupleInfo searchCoupleByCoupleName(String coupleName) throws Exception
	{

		try{

			Session session = getSession();
			Query query = session.createQuery("from CoupleSignUp where coupleName =:coupleName");
			query.setString("coupleName", coupleName);

			CoupleSignUp csu = (CoupleSignUp) query.uniqueResult();
			session.close();
			return csu.getCoupleInfo();

		}
		catch (HibernateException e) {
			throw new Exception("showing exception on fetching user as" + e);
		}

	}


	public ArrayList<CoupleInfo> searchCouplesByAge(int minAge, int maxAge) throws Exception
	{	

		try {
			Session session = getSession();
			Query query = session.createQuery("from Person where age>=:minAge AND age<=:maxAge");
			query.setInteger("minAge", minAge);
			query.setInteger("maxAge", maxAge);

			ArrayList<Person> personList = (ArrayList<Person>) query.list();

			Query query2 = session.createQuery("from CoupleInfo");
			ArrayList<CoupleInfo> allCouples = (ArrayList<CoupleInfo>) query2.list();

			ArrayList<CoupleInfo> results = new ArrayList<CoupleInfo>();
			for(Person p: personList)
			{	
				for(CoupleInfo ci: allCouples)
				{
					if(!results.contains(ci) && p.getCoupleInfo().equals(ci))
					{
						results.add(ci);
					}
				}

			}

			session.close();
			return results;
		} catch (HibernateException e) {
			throw new Exception("showing exception on fetching user as" + e);
		}

	}





	@SuppressWarnings("unchecked")
	public ArrayList<CoupleInfo> searchCouplesByActivity(String activity) throws Exception
	{
		ArrayList<CoupleInfo> mainList = new ArrayList<CoupleInfo>();
		ArrayList<CoupleInfo> coupleList = new ArrayList<CoupleInfo>();
		try{
			Session session = getSession();
			Query query = session.createQuery("from CoupleInfo");
			coupleList = (ArrayList<CoupleInfo>) query.list();
			// iterating couple list to find activities list and then iterating activities to find activities
				System.out.println("System Query Results: Length:"+coupleList.size());
			for(CoupleInfo cInfo : coupleList){
				for(Activities activitcouple : cInfo.getActivityList()){
					if(activitcouple.getActivityName().equalsIgnoreCase(activity)){
						mainList.add(cInfo);
					}
				}
			}
			System.out.println("Returning Results: Length:"+mainList.size());
			session.close();
			return mainList;

		}catch (HibernateException e) {
			throw new Exception("showing exception on fetching user as" + e);
		}

	}

}

