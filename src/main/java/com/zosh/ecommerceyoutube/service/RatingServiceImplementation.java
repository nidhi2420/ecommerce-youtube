package com.zosh.ecommerceyoutube.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zosh.ecommerceyoutube.exceptions.ProductException;
import com.zosh.ecommerceyoutube.model.Product;
import com.zosh.ecommerceyoutube.model.Ratings;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.repository.RatingRepository;
import com.zosh.ecommerceyoutube.request.RatingRequest;

public class RatingServiceImplementation implements RatingService {

	@Autowired
    private	RatingRepository ratingRepository;
	
	@Autowired
	private ProductService productService;

	
	@Override
	public Ratings createRating(RatingRequest req, User user) throws ProductException {
		// TODO Auto-generated method stub
		Product product = productService.findProductById(req.getProductId());
		Ratings ratings = new Ratings();
		ratings.setProduct(product);
		ratings.setRating(req.getRating());
		ratings.setUser(user);
		ratings.setCreatedAt(LocalDateTime.now());	
		return ratingRepository.save(ratings);
	}

	@Override
	public List<Ratings> getProductRating(Long productId) {
		
		return ratingRepository.getAllProductsRating(productId);
		
	}

}
