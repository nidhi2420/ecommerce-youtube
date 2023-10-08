package com.zosh.ecommerceyoutube.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zosh.ecommerceyoutube.exceptions.ProductException;
import com.zosh.ecommerceyoutube.exceptions.UserException;
import com.zosh.ecommerceyoutube.model.Cart;
import com.zosh.ecommerceyoutube.model.CartItem;
import com.zosh.ecommerceyoutube.model.User;
import com.zosh.ecommerceyoutube.request.AddItemrequest;
import com.zosh.ecommerceyoutube.response.ApiResponse;
import com.zosh.ecommerceyoutube.service.CartService;
import com.zosh.ecommerceyoutube.service.UserService;

@RestController
@RequestMapping("/api")
public class CartController {
	
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt)throws UserException{
		User user = userService.findUserProfileByJwt(jwt);
		Cart cart = cartService.findUserCart(user.getId());
		System.out.println("cart - "+cart.getUser().getEmail());		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);	
	}
	
	@PutMapping("/add")
	public ResponseEntity<CartItem> addItemToCart(@RequestBody AddItemrequest req,@RequestHeader("Authorization") String jwt)throws UserException,ProductException{
		User user =userService.findUserProfileByJwt(jwt);
		CartItem item = cartService.addCartItem(user.getId(), req);	
		ApiResponse res= new ApiResponse("Item Added To Cart Successfully",true);
		
		return new ResponseEntity<>(item,HttpStatus.ACCEPTED);
	}

}
