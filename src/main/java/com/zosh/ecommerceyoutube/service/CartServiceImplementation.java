package com.zosh.ecommerceyoutube.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.ecommerceyoutube.exceptions.ProductException;
import com.zosh.ecommerceyoutube.model.Cart;
import com.zosh.ecommerceyoutube.model.CartItem;
import com.zosh.ecommerceyoutube.model.Product;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.repository.CartRepository;
import com.zosh.ecommerceyoutube.request.AddItemrequest;

@Service
public class CartServiceImplementation implements CartService {

	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ProductService productService;
	
	
	@Override
	public Cart createCart(User user) {
	 
		Cart cart = new Cart();
		cart.setUser(user);
		cartRepository.save(cart);
		return cart;
		
	}

	@Override
	public CartItem addCartItem(Long userId, AddItemrequest req) throws ProductException {
	  Cart cart = cartRepository.findByUserId(userId);
	  Product product = productService.findProductById(req.getProductId());
	  
	  CartItem isPresent = cartItemService.isCartItemExist(cart, product, req.getSize(), userId);
	  if(isPresent == null) {
		  CartItem cartItem = new CartItem();
		  cartItem.setProduct(product);
		  cartItem.setCart(cart);
		  cartItem.setQuantity(req.getQuantity());
		  cartItem.setUserId(userId);
		  
		  int price = req.getQuantity()*product.getDiscountedPrice();
		  
		  cartItem.setPrice(price);
		  cartItem.setSize(req.getSize());
		  
		  CartItem createdCartItem = cartItemService.createCartItem(cartItem);
		  cart.getCartItems().add(createdCartItem);
	  }
	  return isPresent;
	}

	@Override
	public Cart findUserCart(Long userId) {
		Cart cart = cartRepository.findByUserId(userId);
		int totalPrice=0;
		int totalDiscountedPrice =0;
		int totalItem = 0;
		
		for(CartItem cartItem:cart.getCartItems()) {
			totalPrice = totalPrice + cartItem.getPrice();
			totalDiscountedPrice = totalDiscountedPrice+ cartItem.getDiscountedPrice();
			totalItem = totalItem + cartItem.getQuantity();
		}
		cart.setTotalDiscountedPrice(totalDiscountedPrice);
		cart.setTotalItem(totalItem);
		cart.setTotalPrice(totalPrice-totalDiscountedPrice);
		
		cartRepository.save(cart);
		return cart;
	}
}
