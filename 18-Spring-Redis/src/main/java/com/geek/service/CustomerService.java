package com.geek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.geek.entity.Customer;
import com.geek.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public Customer addNewCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	@Cacheable(value="customer", key="#root.args[0]")
	public Customer getCustomerById(int id) {
		System.out.println("Fetching Customers From Database . . .");
		return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found !"));
	}
	
	@Cacheable(value="customer", key="'all'")
	public List<Customer> getAllCustomer(){
		System.out.println("Fetching All Customers From Database . . .");
		return customerRepo.findAll();
	}
}
