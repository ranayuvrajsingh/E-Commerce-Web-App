package com.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.signup.Service.UserService;


@SpringBootApplication



public class SignupApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;


	public static void main(String[] args) {
		SpringApplication.run(SignupApplication.class, args);
	}
	
	


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting Code"); 
		
		
//		User user = new User();
//		user.setFirstName("Rana");
//		user.setLastName("Singh");
//		user.setUserName("Yuvz");
//		user.setPassword("abc");
//		user.setEmail("Yuvz@gamil.com");
//		
//		Role role1=new Role();
//		role1.setRoleId(44);
//		role1.setRoleName("User");
//		
//		
//		Set<UserRole> userrolesSet=new HashSet<>();
//		
//		UserRole userRole=new UserRole();
//		userRole.setRoles(role1);
//		userRole.setUser(user);
//		userrolesSet.add(userRole);
//		
//		User user1= this.userService.createUser(user, userrolesSet);
//		
//		System.out.println(user1.getUserName());
//		
	}

}
