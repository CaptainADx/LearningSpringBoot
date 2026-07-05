package com.codingninjas.Foodies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.service.MainService;

@RestController
public class MainController {

	@Autowired
	MainService service;

	@PostMapping("/Restaurant/add")
	public void addNewRestaurant(@RequestBody Restaurant restaurant) {
		service.addNewRestaurant(restaurant);
	}

	@PostMapping("/Customer/add")
	public void addNewCustomer(@RequestBody Customer customer) {
		service.addNewCustomer(customer);
	}

	@PostMapping("/Rating/{customerId}/add/{restaurantName}")
	public void addNewRating(@RequestBody Rating rating, @PathVariable Integer customerId,
			@PathVariable String restaurantName) {
		service.addNewRating(rating, customerId, restaurantName);
	}

	@GetMapping("/ratings")
	public List<Rating> getAllRatings() {
		return service.getAllRatings();
	}

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}

	@GetMapping("/customers/restaurant/{restaurantName}")
	public List<Customer> getAllCustomerByVisitedRestaurant(@PathVariable String restaurantName) {
		return service.allCustomersByVistiedRestaurants(restaurantName);
	}
	
	@GetMapping("/customers/restaurant/{restaurantName}/{rating}")
	public List<Customer> getAllCustomerWithRatingGreaterThan(@PathVariable String restaurantName,@PathVariable double rating){
		return service.getAllCustomerWithRatingGreaterThan(restaurantName, rating);
	}
	
	@GetMapping("/restaurant/{restaurantName}/average")
	public Double getAvgRatingByRestaurant(@PathVariable String restaurantName){
		return service.getAvgRatingByRestaurant(restaurantName);
	}
		

}
