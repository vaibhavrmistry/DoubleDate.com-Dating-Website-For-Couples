package com.neu.edu.DAO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.neu.edu.Model.Activities;
import com.neu.edu.Model.CoupleInfo;
import com.neu.edu.Model.CoupleSignUp;
import com.neu.edu.Model.Person;

public class CoupleInfoDAO extends DAO{

	public ArrayList<Activities> retreiveActivity(String[] actSel) throws HibernateException{
		ArrayList<Activities> actList  = new ArrayList<Activities>();
		try {
			int length = actSel.length;
			for(int i=0; i<length; i++){
				Session session = getSession();
				Query query = session.createQuery("from Activities where activityName =:name");
				query.setString("name", actSel[i]);
				Activities activities = (Activities) query.uniqueResult();
				actList.add(activities);
				session.close();
			}
		} catch (HibernateException e) {
			// TODO: handle exception
		}

		//		System.out.println("findind for the activity list here in retreiving activity from db" + actList.get(i).getActivityId() + actList.get(i).getActivityName());
		return actList;
	}



	public CoupleInfo addCoupleInfo(Person person1,Person person2, CoupleInfo coupleInfo, CoupleSignUp csu, ArrayList<Activities> activitiesList) throws HibernateException{
		CoupleInfo cinfo = csu.getCoupleInfo();
		Session session = getSession();
		Transaction tx = session.beginTransaction();


		if(cinfo==null){
			List<Person> personList = new ArrayList<Person>();
			person1.setCoupleInfo(coupleInfo);
			person2.setCoupleInfo(coupleInfo);
			personList.add(person1);
			personList.add(person2);
			coupleInfo.setPersonList(personList);
			coupleInfo.setActivityList(activitiesList);
			csu.setCoupleInfo(coupleInfo);
			session.save(coupleInfo);
			session.update(csu);
			tx.commit();
			session.close();
			return coupleInfo;
		} else {   // can use copy construtor to copy the data from existing object
			String story1 = coupleInfo.getStory();
			String lookingfor1 = coupleInfo.getLookingfor();
			String restaurants1 = coupleInfo.getRestaurants();
			String musicArtists1 = coupleInfo.getMusicArtists();
			String location1 = coupleInfo.getLocation();
			Person personA = cinfo.getPersonList().get(0);
			Person personB = cinfo.getPersonList().get(1);
			personA.setAge(person1.getAge());
			personA.setEmailId(person1.getEmailId());
			personA.setFirstName(person1.getFirstName());
			personA.setLastName(person1.getLastName());
			personA.setHometown(person1.getHometown());
			personA.setOccupation(person1.getOccupation());
			personA.setPhone(person1.getPhone());

			// entering for person 2
			personB.setAge(person2.getAge());
			personB.setEmailId(person2.getEmailId());
			personB.setFirstName(person2.getFirstName());
			personB.setLastName(person2.getLastName());
			personB.setHometown(person2.getHometown());
			personB.setOccupation(person2.getOccupation());
			personB.setPhone(person2.getPhone());
			
			cinfo.getPersonList().add(0, personA);
			cinfo.getPersonList().add(1, personB);
			cinfo.setActivityList(activitiesList);
			cinfo.setLocation(location1);
			cinfo.setLookingfor(lookingfor1);
			cinfo.setStory(story1);
			cinfo.setRestaurants(restaurants1);
			cinfo.setMusicArtists(musicArtists1);
			
			session.update(cinfo);
			//session.update(personA);
			//session.update(personB);
			tx.commit();
			session.close();
			return cinfo;
		}
	}

	public CoupleSignUp fetchViewCouple(String coupleName){
		System.out.println("inside method, Couple Name is "+coupleName );
		Session session = getSession();
		Query query = session.createQuery("from CoupleSignUp where coupleName =:coupleName1");
		query.setString("coupleName1", coupleName);
		CoupleSignUp coupleSignUp =  (CoupleSignUp) query.uniqueResult();
		System.out.println("value inside method " + coupleSignUp.getCoupleName());
		session.close();
		return coupleSignUp;
	}
}
