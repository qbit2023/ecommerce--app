package com.eshopee.service;

import org.springframework.stereotype.Service;

import com.eshopee.model.Order;
import com.eshopee.model.OrderItem;
import com.eshopee.repository.OrderItemRepository;
import com.eshopee.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public void placeOrder(Order order) {

		Order currentOrder = new Order();
		currentOrder.setCreatedAt(new Date());
		currentOrder.setCustomer(order.getCustomer());
		currentOrder.setTotalPrice(order.getTotalPrice());
		currentOrder.setOrderItems(order.getOrderItems());
		orderRepository.save(currentOrder);

		for (OrderItem item : order.getOrderItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setcreatedAt(new Date());
			orderItem.setPrice(item.getPrice());
			orderItem.setProduct(item.getProduct());
			orderItem.setqty(item.getqty());
			orderItem.setOrder(currentOrder);
			orderItemRepository.save(orderItem);
		}

	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
