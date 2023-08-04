package com.eshopee.service;

import java.util.List;
import java.util.Optional;

import com.eshopee.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	
    public Optional<Customer> getCustomerById(Long id);
    
    public Customer saveCustomer(Customer customer);
   
    public void deleteCustomer(Long id);     
}
