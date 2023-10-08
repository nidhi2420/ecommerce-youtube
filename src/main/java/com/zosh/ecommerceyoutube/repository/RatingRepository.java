package com.zosh.ecommerceyoutube.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zosh.ecommerceyoutube.model.Ratings;

@Repository
public interface RatingRepository extends  JpaRepository<Ratings, Long> {
    @Query("SELECT r From Ratings r Where r.product.id=:productId")
	public List<Ratings> getAllProductsRating(@Param("productId") Long productId);
	
}
