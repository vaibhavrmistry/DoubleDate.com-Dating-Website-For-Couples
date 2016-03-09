package com.neu.edu.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="inbox")
public class Inbox implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue
	@Column(name = "InboxId")
	private int inboxId;

	@Column(name = "Message")
	private String message;

	@Column(name="DateOfMsg")
	private Date dateOfMsg;

	//Inbox-->CoupleInfo
	@ManyToOne
	@JoinColumn(name = "fromUser")
	private CoupleSignUp fromUser;

	//Inbox-->Couplenfo
	@ManyToOne
	@JoinColumn(name = "toUser")
	private CoupleSignUp toUser;

	public Inbox(){
		dateOfMsg = new Date();
	}

	public int getInboxId() {
		return inboxId;
	}

	public void setInboxId(int inboxId) {
		this.inboxId = inboxId;
	}



	public Date getDateOfMsg() {
		return dateOfMsg;
	}

	public void setDateOfMsg(Date dateOfMsg) {
		this.dateOfMsg = dateOfMsg;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CoupleSignUp getFromUser() {
		return fromUser;
	}

	public void setFromUser(CoupleSignUp fromUser) {
		this.fromUser = fromUser;
	}

	public CoupleSignUp getToUser() {
		return toUser;
	}

	public void setToUser(CoupleSignUp toUser) {
		this.toUser = toUser;
	}

	//method for creating a new date everytime in the table

	//	@PrePersist
	//	protected void onCreate()
	//	{
	//		dateOfMsg = new Date();
	//	}
}
