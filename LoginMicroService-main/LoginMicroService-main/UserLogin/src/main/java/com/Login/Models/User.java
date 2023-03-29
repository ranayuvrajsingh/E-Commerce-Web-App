package com.Login.Models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="Users")
public class User implements UserDetails {

	
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String phone;
	private String address;
	private String profile;
	

	private boolean enabled=true;
	                                                               //mapped used so that new table 
	                                                               // will not be created
	@OneToMany (cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy="user")
	@JsonIgnore                                        //To avoid Circular Dependency 
	 private Set<UserRole>  userRoles=new HashSet<>();
	
	
	//Getter &Setter
	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	

	// Default Constructor
	public User() {
		
		
	}

	//Getter & Setter
	
	public long getId() {
		return id;
	}


	public void setId(long idd) {
		id = idd;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	// changed recently
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	


	
	//Parametrized Constructor
	
	public User(long idd, String firstName, String lastName, String userName, String password, String email,
			String phone, boolean enabled,String address,String profile) {
		
		id = idd;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		//changed
		this.address=address;
		this.profile=profile;
		this.enabled = enabled;
		
	}
	
	
	//Jwt Authentication   //Security Credentials

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		Set<Authority> set=new HashSet<>();
		
		this.userRoles.forEach(userRole ->{
			set.add(new Authority(userRole.getRoles().getRoleName()));
			
		});
		
		
		
		
		return set; //ye maine change kiya tha;
	}
	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
       return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
	
	
	
	
	
	
}
