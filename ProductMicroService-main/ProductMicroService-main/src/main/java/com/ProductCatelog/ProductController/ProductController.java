package com.ProductCatelog.ProductController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ProductCatelog.Dto.ProductDto;
import com.ProductCatelog.ProductService.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin("*")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	
	
	//Post
	@PostMapping("/")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto)
	{
		ProductDto createProductDto=this.productService.createProduct(productDto);
		return  new ResponseEntity<ProductDto>(createProductDto,HttpStatus.CREATED);
		
		
	}
	
	
	
	
	
	//Put
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable("id") Integer id)
	{
		ProductDto updatedProduct=this.productService.updateProduct(productDto, id);
		
		return ResponseEntity.ok(updatedProduct);
	}
	
	
	//Delete
	@SuppressWarnings("unchecked")
	@DeleteMapping("/{id}")
	@CrossOrigin("http://localhost:4200")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id)
	{
		this.productService.deleteProduct(id);
		return new  ResponseEntity(Map.of("message","Product Deleted Successfully"),HttpStatus.OK);
	}
	

	
	
	
	//Get

	@GetMapping("/")
	public  ResponseEntity<List<ProductDto>> getAllProducts()
	{
		return ResponseEntity.ok(this.productService.getAllProducts());
	}
	
	
	//Get One Product
	@GetMapping("/{id}")
	public  ResponseEntity<ProductDto> getSingleProduct(@PathVariable("id") Integer id)
	{
		return ResponseEntity.ok(this.productService.getProductById(id));
	}
}
