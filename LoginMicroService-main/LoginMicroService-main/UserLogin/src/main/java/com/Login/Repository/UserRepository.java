package com.Login.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Login.Models.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByUserName(String userName);



	
}
