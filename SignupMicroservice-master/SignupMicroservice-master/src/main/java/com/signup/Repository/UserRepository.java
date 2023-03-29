package com.signup.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signup.Models.User;



public interface UserRepository extends JpaRepository<User,Long> {

	User findByUserName(String userName);



	
}
