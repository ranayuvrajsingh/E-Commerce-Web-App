package com.Login.Models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long  userRoleId;
	
	//Single user
	@ManyToOne (fetch=FetchType.EAGER) //To fetch All the Value
	private User user;
	
	@ManyToOne (fetch=FetchType.EAGER)
	private Role roles;
	
	
	//Default Constructor
	public UserRole() {
		
	}


	


	
	//Getter & Setter
	public long getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Role getRoles() {
		return roles;
	}


	public void setRoles(Role roles) {
		this.roles = roles;
	}
	
	
	
	
	

}
