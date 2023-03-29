package com.ProductCatelog.ProductRepository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductCatelog.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	

 
}
