package com.ProductCatelog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ProductCatelog.Models.Product;

@SpringBootApplication
public class ProductCatelogApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductCatelogApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting  Product Catelog");
		
		
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}

}
