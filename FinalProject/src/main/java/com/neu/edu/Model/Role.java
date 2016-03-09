package com.neu.edu.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static String Admin = "admin";
	public final static String User = "user";
	public final static String CustomerCare = "customerCare";

	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	private int id;
	private String role;

	//	@OneToMany(cascade=CascadeType.ALL)
	//	@JoinTable(name="USER_ROLE", joinColumns={@JoinColumn(name="roleid", referencedColumnName="id")},
	//	inverseJoinColumns={@JoinColumn(name="userid", referencedColumnName="coupleId")})
	//	private List<CoupleSignUp> coupleList;

	public Role(){

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
