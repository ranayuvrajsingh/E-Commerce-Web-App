package com.Login.Service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.Login.Models.User;
import com.Login.Models.UserRole;

@Service
public interface UserService {

	
	//Creating User
	public User createUser(User user,Set<UserRole>  userRoles) throws Exception;
	
	
	//Get user by User Name
	public User getUser (String userName);
	
	//Delete User By Username
	public void deleteUser(String userName);
	
	//Delete By User Id
	public void deleteUser(Long userId);
	

	
	
	
}
