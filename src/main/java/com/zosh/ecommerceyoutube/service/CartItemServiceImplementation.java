package com.zosh.ecommerceyoutube.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zosh.ecommerceyoutube.exceptions.CartItemException;
import com.zosh.ecommerceyoutube.exceptions.UserException;
import com.zosh.ecommerceyoutube.model.Cart;
import com.zosh.ecommerceyoutube.model.CartItem;
import com.zosh.ecommerceyoutube.model.Product;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.repository.CartItemRepository;
import com.zosh.ecommerceyoutube.repository.CartRepository;

@Service
public class CartItemServiceImplementation implements CartItemService {

	
	@Autowired
	private CartItemRepository cartItemRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public CartItem createCartItem(CartItem cartItem) {
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getProduct().getPrice() *cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice() * cartItem.getQuantity());
	    CartItem createCartItem = cartItemRepository.save(cartItem);
	    return createCartItem;
	}

	@Override
	public CartItem updaCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException {
		// TODO Auto-generated method stub
		CartItem item = findCartItemById(id);
		User user = userService.findUserById(userId);
		if(user.getId().equals(userId)) {
			item.setQuantity(item.getQuantity());
			item.setPrice(item.getQuantity()*item.getProduct().getPrice());
			item.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice() * cartItem.getQuantity());
		
		}
		
		
		return cartItemRepository.save(item);
	}

	@Override
	public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {
		CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);
		return cartItem;
	}

	@Override
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
		
		CartItem cartItem = findCartItemById(cartItemId);
		User user = userService.findUserById(cartItem.getUserId());
		
		User reqUser = userService.findUserById(userId);
		if(user.getId().equals(reqUser.getId())) {
			cartItemRepository.deleteById(cartItemId);
		}
		else {
			throw new UserException("you cant remove another user item");
		}
		
	}

	@Override
	public CartItem findCartItemById(Long CartItemId) throws CartItemException {
		Optional<CartItem> opt=cartItemRepository.findById(CartItemId);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new CartItemException("cartItem not found with id : "+CartItemId);
	}
	}

	

