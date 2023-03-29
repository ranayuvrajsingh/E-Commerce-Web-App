package com.Login;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.Login.Models.Role;
import com.Login.Models.User;
import com.Login.Models.UserRole;
import com.Login.Service.UserService;
import com.Login.helper.UserFoundException;

@SpringBootApplication
public class UserLoginApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
	


	public static void main(String[] args) {
		SpringApplication.run(UserLoginApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		try {
		// TODO Auto-generated method stub
		System.out.println("Starting Code"); 
		
		
		User user = new User();
		user.setId(1);
		user.setFirstName("Rana");
		user.setLastName("Singh");
		user.setUserName("Yuvz");
//		user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		user.setPassword("abc");
		user.setEmail("Yuvz@gamil.com");
		
		Role role1=new Role();
		role1.setRoleId(44);
		role1.setRoleName("User");
		
		
		Set<UserRole> userrolesSet=new HashSet<>();
		
		UserRole userRole=new UserRole();
		userRole.setRoles(role1);
		userRole.setUser(user);
		userrolesSet.add(userRole);
		
		User user1= this.userService.createUser(user, userrolesSet);
		
		System.out.println(user1.getUserName());
		
   }
		catch(UserFoundException e)
		{
			e.printStackTrace();
		}

		}
}
