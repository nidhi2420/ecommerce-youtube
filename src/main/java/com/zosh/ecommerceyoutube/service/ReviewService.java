package com.zosh.ecommerceyoutube.service;

import java.util.List;

import com.zosh.ecommerceyoutube.exceptions.ProductException;
import com.zosh.ecommerceyoutube.model.Review;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.request.ReviewRequest;

public interface ReviewService {
 
	public Review createReview(ReviewRequest req,User user)throws ProductException;
    public List<Review> getAllReview(Long productId);
    

}
