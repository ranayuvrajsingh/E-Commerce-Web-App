package com.ProductCatelog.ProductService.ProductServiceImpl;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductCatelog.CustomException.ResourceNotFoundException;
import com.ProductCatelog.Dto.ProductDto;
import com.ProductCatelog.Models.Product;
import com.ProductCatelog.ProductRepository.ProductRepository;
import com.ProductCatelog.ProductService.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public ProductDto createProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		Product product=this.dtoToProduct(productDto);
		 Product savedProduct=this.productRepository.save(product);
		
		return this.productToDto(savedProduct) ;
		
		
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto, Integer id) {
		// TODO Auto-generated method stub
       Product product=this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","id",id));
		product.setId(productDto.getId());
		product.setProductName(productDto.getProductName());
		product.setPrice(productDto.getPrice());
//		product.setImage(productDto.getImage());
		product.setAvailability(productDto.isAvailability());
		product.setDescription(productDto.getDescription());
		product.setReview(productDto.getReview());
		
		Product updateProduct=this.productRepository.save(product);
		ProductDto productDtos=this.productToDto(updateProduct);
		return productDtos;
		
		
	}

	@Override
	public ProductDto getProductById(Integer id) {
		// TODO Auto-generated method stub
		Product product=this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","id",id));
		return this.productToDto(product);
		
		
	
	}

	@Override
	public List<ProductDto> getAllProducts() {
		
		// TODO Auto-generated method stub
	  List<Product>  products=this.productRepository.findAll();
	  List<ProductDto> productDtos= products.stream().map(product->this.productToDto(product)).collect(Collectors.toList());
		return productDtos;
	
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		Product product=this.productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product","id",id));

		this.productRepository.delete(product);
	}
	
	//Mapping

	
	private Product dtoToProduct (ProductDto productDto)
	{
		Product product=new Product();
	//	product.setId(productDto.getId());
		product.setProductName(productDto.getProductName());
		product.setPrice(productDto.getPrice());
		product.setDescription(productDto.getDescription());
		product.setAvailability(productDto.isAvailability());
//		product.setImage(productDto.getImage());
		product.setReview(productDto.getReview());
		
		return product;
		
		
	}
	
	public ProductDto productToDto(Product product) {
		
		ProductDto productToDto=new ProductDto();
		productToDto.setId(product.getId());
		productToDto.setProductName(product.getProductName());
		productToDto.setPrice(product.getPrice());
		productToDto.setDescription(product.getDescription());
		productToDto.setAvailability(product.isAvailability());
//		productToDto.setImage(product.getImage());
		productToDto.setReview(product.getReview());
		
		
		return productToDto;

 }

	

	 
}
