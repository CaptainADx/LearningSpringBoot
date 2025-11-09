package com.geek.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.entity.Customer;
import com.geek.repository.CustomerRepository;
import com.geek.service.CustomerService;

@RestController
public class CustomerApi {

    private final CustomerRepository customerRepository;
	
	@Autowired
	private CustomerService customerService;

    CustomerApi(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
	
	@PostMapping("/addCustomer")
	public Customer addNewCustomer(@RequestBody Customer c) {
		return customerService.addNewCustomer(c);
	}
	 
	@GetMapping("/getCustomer/{id}") 
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
	}
}
