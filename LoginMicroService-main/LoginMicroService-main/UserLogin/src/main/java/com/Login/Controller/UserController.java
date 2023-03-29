package com.Login.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Login.Models.Role;
import com.Login.Models.User;
import com.Login.Models.UserRole;
import com.Login.Service.UserService;

@RestController
@RequestMapping("/user")

public class UserController {
 
	@Autowired
	private UserService userService;

	
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
	//creating 
	
	@PostMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	
	public User createUser(@RequestBody User user) throws Exception {
		
		
		user.setProfile("default.png");
		//encoding password with BCryptencoder
//	user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
		
		
		
		
		Set<UserRole> roles=new HashSet<>();
		
		//Role
		Role role=new Role();
		role.setRoleId(45L);
		role.setRoleName("Normal");
		
		//UserRole
		UserRole userRole=new UserRole();
		userRole.setUser(user);
		userRole.setRoles(role);
		
		
		roles.add(userRole);
		
		return this.userService.createUser(user, roles);
		
	}
	
	//Getting User
	
	@GetMapping("/{userName}")
	public User getUser(@PathVariable("userName") String userName) {
		return this.userService.getUser(userName);
	}
	

	//Delete User by UserName
		@DeleteMapping("/{userName}")
		public void deleteUser(@PathVariable("userName") String userName) {
			
			this.userService.deleteUser(userName);
		}
		
		
		//Delete User Bu UserId
		@DeleteMapping("/delete/{userId}")
		public void deleteUserById(@PathVariable("userId") Long userId) {
			this.userService.deleteUser(userId);
		}

	
}
