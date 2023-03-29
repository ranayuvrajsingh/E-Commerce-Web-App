package com.Login.Service.Implementation;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Login.Models.User;
import com.Login.Models.UserRole;
import com.Login.Repository.RoleRepository;
import com.Login.Repository.UserRepository;
import com.Login.Service.UserService;
import com.Login.helper.UserFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	
	
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	

	
	//Creating User
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		// TODO Auto-generated method stub
		
		User local=this.userRepository.findByUserName(user.getUserName());
		
		if(local!=null) {
			System.out.println("User Is already There !! ");
//			throw new Exception("User Already Present !!"); 
			throw new UserFoundException("User Already Present !!");
		}
		else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRoles());
			}
			user.getUserRoles().addAll(userRoles);
			local=this.userRepository.save(user);
		}
		
		
		return local;
	}





	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUserName(userName);
	}





	@Override
	public void deleteUser(String userName) {
		// TODO Auto-generated method stub
		User user= this.userRepository.findByUserName(userName);
		this.userRepository.delete(user);
		
	}





	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		this.userRepository.deleteById(userId);
	}














}
