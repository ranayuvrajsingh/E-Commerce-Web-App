////package com.ProductCatelog.Models;
////
////import javax.persistence.Entity;
////import javax.persistence.GeneratedValue;
////import javax.persistence.GenerationType;
////import javax.persistence.Id;
////import javax.persistence.ManyToMany;
////import javax.persistence.OneToOne;
////import javax.persistence.Table;
////
////import org.apache.catalina.User;
////
////@Entity
////@Table
////public class Cart {
////	
////
////	@Id
////	@GeneratedValue(strategy=GenerationType.AUTO)
////	private int cartId;
////
////	@ManyToMany
////	private Product product;
////	
////	@OneToOne
////	private User user;
////	
////	
////	
////	
////	public Cart() {
////		
////	}
////
////
////	//Parameterized Constructor
////
////
////	public Cart(int cartId, Product product, User user) {
////		super();
////		this.cartId = cartId;
////		this.product = product;
////		this.user = user;
////	}
////
//
//	
//	
//	
//    //Getter & Setter
//	public int getCartId() {
//		return cartId;
//	}
//
//
//
//
//	public void setCartId(int cartId) {
//		this.cartId = cartId;
//	}
//
//
//
//
//	public Product getProduct() {
//		return product;
//	}
//
//
//
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//
//
//
//
//	public User getUser() {
//		return user;
//	}
//
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//	
//	
//	
//
//}
