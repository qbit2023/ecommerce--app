package com.eshopee.dto.order;

import com.eshopee.model.Order;

public class OrderDto {

	private Long id;
	private Long userId;

	public OrderDto() {
	}

	public OrderDto(Order order) {
		this.setId(order.getId());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long long1) {
		this.id = long1;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
