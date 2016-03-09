package com.neu.edu.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name = "USER_ROLE")
public class UserRole {

	private static final long serialVersionUID = 1L;


	public int getMainID() {
		return mainID;
	}

	public void setMainID(int mainID) {
		this.mainID = mainID;
	}

	//	@Id
	//	@GeneratedValue(strategy=GenerationType.AUTO)
	//	@Column(name="mainId", unique=true)
	private int mainID;
	private int roleId;
	private int userId;


	public UserRole(){

	}

	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
