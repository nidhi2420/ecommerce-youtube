package com.zosh.ecommerceyoutube.service;

import java.util.List;

import com.zosh.ecommerceyoutube.exceptions.OrderException;
import com.zosh.ecommerceyoutube.model.Address;
import com.zosh.ecommerceyoutube.model.Order;
import com.zosh.ecommerceyoutube.model.User;

public interface OrderService  {
 
	public Order createOrder(User user, Address shippingAdress);
	
	public Order findOrderById(Long orderId) throws OrderException;
	
	public List<Order> usersOrderHistory(Long userId);
	
	public Order placedOrder(Long orderId) throws OrderException;
	
	public Order confirmedOrder(Long orderId)throws OrderException;
	
	public Order shippedOrder(Long orderId) throws OrderException;
	
	public Order deliveredOrder(Long orderId) throws OrderException;
	
	public Order cancledOrder(Long orderId) throws OrderException;
	
	public List<Order>getAllOrders();
	
	public void deleteOrder(Long orderId) throws OrderException;
}
