package com.eshopee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.eshopee.model.Order;
import com.eshopee.service.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")

public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping

	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@PostMapping("/create")

	public ResponseEntity<String> createOrder(@RequestBody Order order) {
		orderService.placeOrder(order);
		return new ResponseEntity<>("Order placed !", HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
		Optional<Order> existingOrder = orderService.getOrderById(id);
		if (existingOrder.isPresent()) {
			orderService.deleteOrder(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
