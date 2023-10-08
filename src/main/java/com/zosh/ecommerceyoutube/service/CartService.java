package com.zosh.ecommerceyoutube.service;

import org.springframework.stereotype.Service;

import com.zosh.ecommerceyoutube.exceptions.ProductException;
import com.zosh.ecommerceyoutube.model.Cart;
import com.zosh.ecommerceyoutube.model.CartItem;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.request.AddItemrequest;

public interface CartService {
	
	
 public Cart createCart(User user);
 
 public CartItem addCartItem(Long userId,AddItemrequest req)throws ProductException;
	
 public Cart findUserCart(Long userId);
 
}
