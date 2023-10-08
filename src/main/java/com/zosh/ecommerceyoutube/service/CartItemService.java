package com.zosh.ecommerceyoutube.service;

import com.zosh.ecommerceyoutube.exceptions.CartItemException;
import com.zosh.ecommerceyoutube.exceptions.UserException;
import com.zosh.ecommerceyoutube.model.Cart;
import com.zosh.ecommerceyoutube.model.CartItem;
import com.zosh.ecommerceyoutube.model.Product;

public interface CartItemService {

	public CartItem createCartItem(CartItem cartItem);
	
	public CartItem updaCartItem(Long userId,Long id,CartItem cartItem)throws CartItemException,UserException;
	
	public CartItem isCartItemExist(Cart cart,Product product,String size,Long userId);
	
	public void removeCartItem(Long userId,Long cartItemId)throws CartItemException,UserException;
	
	public CartItem findCartItemById(Long CartItemId)throws CartItemException;
	
}
