package com.zosh.ecommerceyoutube.service;

import java.util.List;

import com.zosh.ecommerceyoutube.exceptions.ProductException;
import com.zosh.ecommerceyoutube.model.Ratings;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.request.RatingRequest;

public interface RatingService {

	public Ratings createRating(RatingRequest req, User user)throws ProductException;
    public List<Ratings> getProductRating(Long productId);
    
}
