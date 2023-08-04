package com.eshopee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshopee.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  
}

