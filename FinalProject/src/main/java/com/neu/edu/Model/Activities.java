package com.neu.edu.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="ACTIVITY")
public class Activities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="activityId", nullable=false, unique=true)
	private int activityId;
	private String activityName;
//	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinTable(name="coupleActivity", joinColumns={@JoinColumn(name="activityId")},
//	inverseJoinColumns={@JoinColumn(name="info_id")})
//	private List<CoupleInfo> coupleList = new ArrayList<CoupleInfo>();

	@ManyToMany(mappedBy = "activityList", fetch=FetchType.LAZY)
	private List<CoupleInfo> coupleList = new ArrayList<CoupleInfo>();
		
	
	public Activities(){

	}
	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public List<CoupleInfo> getCoupleList() {
		return coupleList;
	}

	public void setCoupleList(List<CoupleInfo> coupleList) {
		this.coupleList = coupleList;
	}
}
