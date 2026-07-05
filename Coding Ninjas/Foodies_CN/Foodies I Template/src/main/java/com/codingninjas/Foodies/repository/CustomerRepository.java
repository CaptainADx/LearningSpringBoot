package com.codingninjas.Foodies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Restaurant;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByVisitedRestaurants(Restaurant restaurant);

	@Query("select c from Customer c Join c.ratings r where r.restaurant = ?1 and r.rating > ?2")
	List<Customer> getAllCustomerWithRatingGreaterThan(Restaurant restaurant, double rating);

}
