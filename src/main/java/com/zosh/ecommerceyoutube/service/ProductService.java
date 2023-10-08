package com.zosh.ecommerceyoutube.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.zosh.ecommerceyoutube.exceptions.ProductException;
import com.zosh.ecommerceyoutube.model.Product;
import com.zosh.ecommerceyoutube.request.CreateProductRequest;

public interface ProductService {
	
	public Product createProduct(CreateProductRequest req);
	
	public String deleteProduct(Long productId)throws ProductException;
    
	public Product updateProduct(Long ProductId,Product req)throws ProductException;
    
    public Product findProductById(Long id)throws ProductException;
    
    public List<Product> findProductByCategory(String category);
    
    public Page<Product> getAllProduct(String category,List<String> colors, List<String> sizes,Integer minPrice,Integer maxPrice ,Integer minDiscount,String sort, String stock ,Integer pageNumber,Integer pageSize )throws ProductException;
    
    public List<Product> getAllProducts();

	public List<Product> recentlyAddedProduct();
}
