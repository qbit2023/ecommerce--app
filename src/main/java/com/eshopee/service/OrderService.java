package com.eshopee.service;

import java.util.List;
import java.util.Optional;


import com.eshopee.model.Order;

public interface OrderService {

	public List<Order> getAllOrders();
	
	public Optional<Order> getOrderById(Long id);

	public void placeOrder(Order order);

	public void deleteOrder(Long id);
}
