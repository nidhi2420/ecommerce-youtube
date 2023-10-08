package com.zosh.ecommerceyoutube.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.ecommerceyoutube.exceptions.ProductException;
import com.zosh.ecommerceyoutube.model.Product;
import com.zosh.ecommerceyoutube.model.Review;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.repository.ProductRepository;
import com.zosh.ecommerceyoutube.repository.ReviewRepository;
import com.zosh.ecommerceyoutube.request.ReviewRequest;

@Service
public class ReviewServiceImplementation  implements ReviewService{

	@Autowired
	private ProductService productService;
	@Autowired
	private ReviewRepository reviewRepository;
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Review createReview(ReviewRequest req, User user) throws ProductException {
		Product product = productService.findProductById(req.getProductId());
		Review review= new Review();
		review.setProduct(product);
		review.setReview(req.getReview());
		review.setUser(user);
		review.setCreatedAt(LocalDateTime.now());
		return reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReview(Long productId) {
		return reviewRepository.getAllProductsReview(productId);
	}

}
