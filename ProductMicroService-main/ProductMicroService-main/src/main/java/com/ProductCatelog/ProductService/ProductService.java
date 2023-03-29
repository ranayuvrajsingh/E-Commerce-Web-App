package com.ProductCatelog.ProductService;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ProductCatelog.Dto.ProductDto;
import com.ProductCatelog.Models.Product;

@Service
public interface ProductService {
	
	
	
	ProductDto createProduct(ProductDto product);
	
	ProductDto updateProduct(ProductDto product,Integer id);
	
	ProductDto getProductById(Integer id);
	
	List<ProductDto>  getAllProducts();
	
    void deleteProduct (Integer id);


}
