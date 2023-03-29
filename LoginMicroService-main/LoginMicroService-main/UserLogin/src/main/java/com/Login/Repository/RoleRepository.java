package com.Login.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Login.Models.Role;


public interface RoleRepository extends JpaRepository<Role,Long> {

}
