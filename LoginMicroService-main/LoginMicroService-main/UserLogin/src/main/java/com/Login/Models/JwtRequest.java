package com.Login.Models;

public class JwtRequest {
	
	String userName;
	String password;
	
	
	//Constructor
	public JwtRequest() {
		
	}
	
	//Parametrized Constructor
	
	public JwtRequest(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}



	//Getter & Setter 
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
