package com.neu.edu.Model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="friend_zone")
public class FriendZone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="relationId", nullable=false, unique=true)
	private int relationId;
	private int fromUser;
	private boolean accepted;
	private boolean unfriend;


	public boolean isUnfriend() {
		return unfriend;
	}

	public void setUnfriend(boolean unfriend) {
		this.unfriend = unfriend;
	}


	private int toUser;


	public FriendZone(){

	}


	public int getRelationId() {
		return relationId;
	}


	public void setRelationId(int relationId) {
		this.relationId = relationId;
	}


	public int getFromUser() {
		return fromUser;
	}


	public void setFromUser(int fromUser) {
		this.fromUser = fromUser;
	}


	public boolean isAccepted() {
		return accepted;
	}


	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}


	public int getToUser() {
		return toUser;
	}


	public void setToUser(int toUser) {
		this.toUser = toUser;
	}


}