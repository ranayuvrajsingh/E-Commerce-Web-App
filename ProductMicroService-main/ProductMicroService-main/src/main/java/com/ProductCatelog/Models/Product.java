package com.ProductCatelog.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name="Products")

public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	private String productName;
	
	
	private String price;
	
	
	private String description;
	
	
	private boolean availability=false;
	
	

	private Long review;




	//Constructor
	public Product() {
		
	}











	   // Getter & Setter
	


	public int getId() {
		return id;
	}









	public void setId(int id) {
		this.id = id;
	}









	public String getProductName() {
		return productName;
	}









	public void setProductName(String productName) {
		this.productName = productName;
	}









	public String getPrice() {
		return price;
	}









	public void setPrice(String price) {
		this.price = price;
	}









	public String getDescription() {
		return description;
	}









	public void setDescription(String description) {
		this.description = description;
	}









	public boolean isAvailability() {
		return availability;
	}









	public void setAvailability(boolean availability) {
		this.availability = availability;
	}








//
//	public Set<Image> getProductImages() {
//		return productImages;
//	}











//	public void setProductImages(Set<Image> productImages) {
//		this.productImages = productImages;
//	}


















	public Long getReview() {
		return review;
	}









	public void setReview(Long review) {
		this.review = review;
	}








	 //Parameter Constructor

	public Product(int id, String productName, String price, String description, boolean availability, Long review) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.availability = availability;
		this.review = review;
	}












	
	
	

	






	

  
	
	
	
	
	
	
	

	
	
}
