package com.neu.edu.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Token_check")
public class CoupleRememberToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int Id;
	private String token_No;

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="coupleId_Fk")
	private CoupleSignUp coupleSignUp;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getToken_No() {
		return token_No;
	}
	public void setToken_No(String token_No) {
		this.token_No = token_No;
	}
	public CoupleSignUp getCoupleSignUp() {
		return coupleSignUp;
	}
	public void setCoupleSignUp(CoupleSignUp coupleSignUp) {
		this.coupleSignUp = coupleSignUp;
	}

}
