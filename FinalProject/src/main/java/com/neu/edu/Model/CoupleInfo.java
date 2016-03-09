package com.neu.edu.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.ManyToAny;
@Entity
@Table(name="COUPLE_INFO")
public class CoupleInfo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="info_Id")
	private int info_Id;
	private String location;
	private String relationshipAge;
	private String story;
	private String lookingfor;
	private String restaurants;
	private String musicArtists;

	public String getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(String restaurants) {
		this.restaurants = restaurants;
	}

	public String getMusicArtists() {
		return musicArtists;
	}

	public void setMusicArtists(String musicArtists) {
		this.musicArtists = musicArtists;
	}


	@OneToMany(targetEntity=Person.class, mappedBy="coupleInfo",
			cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Person> personList;


	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name="coupleActivity", joinColumns={@JoinColumn(name="info_id")},
	inverseJoinColumns={@JoinColumn(name="activityId")})
	private List<Activities> activityList = new ArrayList<Activities>();


	public List<Activities> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<Activities> activityList) {
		this.activityList = activityList;
	}

	public CoupleInfo(){

	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLookingfor() {
		return lookingfor;
	}

	public void setLookingfor(String lookingfor) {
		this.lookingfor = lookingfor;
	}


	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public int getInfo_Id() {
		return info_Id;
	}

	public void setInfo_Id(int info_Id) {
		this.info_Id = info_Id;
	}

	public String getRelationshipAge() {
		return relationshipAge;
	}


	public void setRelationshipAge(String relationshipAge) {
		this.relationshipAge = relationshipAge;
	}

	public String getStory() {
		return story;
	}


	public void setStory(String story) {
		this.story = story;
	}

}
