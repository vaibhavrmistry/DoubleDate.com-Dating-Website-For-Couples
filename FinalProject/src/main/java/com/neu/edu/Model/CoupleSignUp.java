package com.neu.edu.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "COUPLE_SIGNUP")
public class CoupleSignUp implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "coupleId", unique = true, nullable = false)
	private int coupleID;
	private String coupleName;
	private String password;
	private String emailId;
	private Boolean authenticated;
	private Boolean remember;

	@ManyToOne(cascade=CascadeType.ALL)
//	@JoinTable(name="USER_ROLE", joinColumns={@JoinColumn(name="userid", referencedColumnName="coupleID")},
//	inverseJoinColumns={@JoinColumn(name="roleid", referencedColumnName="id")})
	private Role role;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="info_Id_FK")
	private CoupleInfo coupleInfo;


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public CoupleSignUp(){

	}

	public int getCoupleID() {
		return coupleID;
	}

	public void setCoupleID(int coupleID) {
		this.coupleID = coupleID;
	}

	public CoupleInfo getCoupleInfo() {
		return coupleInfo;
	}

	public void setCoupleInfo(CoupleInfo coupleInfo) {
		this.coupleInfo = coupleInfo;
	}

	public String getCoupleName() {
		return coupleName;
	}

	public void setCoupleName(String coupleName) {
		this.coupleName = coupleName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	public Boolean getRemember() {
		return remember;
	}

	public void setRemember(Boolean remember) {
		this.remember = remember;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
