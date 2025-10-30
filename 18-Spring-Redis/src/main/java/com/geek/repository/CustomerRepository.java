package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
}
