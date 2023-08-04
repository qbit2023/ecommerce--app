package com.eshopee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshopee.model.OrderItem;
import com.eshopee.repository.OrderItemRepository;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;

	public void saveOrderedProducts(OrderItem orderItem) {
		orderItemRepository.save(orderItem);
	}
}
