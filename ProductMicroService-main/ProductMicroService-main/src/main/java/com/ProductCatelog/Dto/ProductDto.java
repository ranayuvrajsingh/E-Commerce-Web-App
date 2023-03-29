package com.ProductCatelog.Dto;







public class ProductDto {

    private int id;
	
	
	private String productName;
	
	
	private String price;
	
	
	private String description;
	
	
	private boolean availability=false;
	
	
	private String image;
	
	
	private Long review;
	
	
	
	
	
	
	

	
	
  


	//Constructor
	


	
	



//	public ProductDto() {
//		// TODO Auto-generated constructor stub
//	}
//









	//Getter & Setter


	public ProductDto(int id, String productName, String price, String description, boolean availability, String image,
			Long review) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.availability = availability;
		this.image = image;
		this.review = review;
	}













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













	public String getImage() {
		return image;
	}













	public void setImage(String image) {
		this.image = image;
	}













	public Long getReview() {
		return review;
	}













	public ProductDto() {
		super();
	}













	public void setReview(Long review) {
		this.review = review;
	}}









