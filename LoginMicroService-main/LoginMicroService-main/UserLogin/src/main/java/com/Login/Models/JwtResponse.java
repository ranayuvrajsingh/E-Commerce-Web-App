package com.Login.Models;

public class JwtResponse {

	String token;

	//Constructor
	
	public JwtResponse() {
		
	}
	
	//Parametrized Constructor
	public JwtResponse(String token) {
		
		this.token = token;
	}


	//Getter & Setter
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
