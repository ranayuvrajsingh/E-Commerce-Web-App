package com.Login.helper;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super("User with this Username Not Found in DB !!  ");
	}
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
