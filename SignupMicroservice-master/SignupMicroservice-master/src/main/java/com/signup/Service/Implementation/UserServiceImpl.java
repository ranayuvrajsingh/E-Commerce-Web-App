package com.signup.Service.Implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.Models.User;
import com.signup.Models.UserRole;
import com.signup.Repository.RoleRepository;
import com.signup.Repository.UserRepository;
import com.signup.Service.UserService;



@Service
public class UserServiceImpl implements UserService {
	
	
	
//	
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	
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
			throw new Exception("User Already Present !!"); 
		}
		else {
			for(UserRole ur:userRoles) {
				roleRepository.save(ur.getRoles());
			}
			user.getUserRoles().addAll(userRoles);
			
//			user.setPassword(this.passwordEncoder.encode(user.getPassword()));
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