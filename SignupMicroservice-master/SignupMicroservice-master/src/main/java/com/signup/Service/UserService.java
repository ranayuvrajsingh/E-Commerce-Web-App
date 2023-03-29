package com.signup.Service;

import java.util.Set;

import com.signup.Models.User;
import com.signup.Models.UserRole;





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


