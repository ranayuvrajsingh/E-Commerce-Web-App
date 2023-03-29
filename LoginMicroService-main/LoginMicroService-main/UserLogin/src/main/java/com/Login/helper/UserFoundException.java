package com.Login.helper;

public class UserFoundException extends Exception {
          
	public UserFoundException() {
		super("User with this Username already there is DB !!  try with another one");
	}
	public UserFoundException(String msg) {
		super(msg);
	}
}
