package com.eshopee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshopee.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom query methods, if needed
}

