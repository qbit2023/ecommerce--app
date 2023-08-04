package com.eshopee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eshopee.model.Customer;
import com.eshopee.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Optional<Customer> getCustomerById(Long id) {
		return customerRepository.findById(id);
	}

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}

}
