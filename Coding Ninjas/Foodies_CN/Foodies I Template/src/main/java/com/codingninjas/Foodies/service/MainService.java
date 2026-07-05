package com.codingninjas.Foodies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.Foodies.entity.Customer;
import com.codingninjas.Foodies.entity.Rating;
import com.codingninjas.Foodies.entity.Restaurant;
import com.codingninjas.Foodies.repository.*;

@Service
public class MainService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;

	public void addNewRestaurant(Restaurant restaurant) {
		restaurantRepository.save(restaurant);
		
	}

	public void addNewCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	public void addNewRating(Rating rating, Integer customerId, String restaurantName) {
		Customer customer = customerRepository.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found"));

	    Restaurant restaurant = restaurantRepository.findByName(restaurantName);

	    if (restaurant == null) {
	        throw new RuntimeException("Restaurant not found");
	    }

	    rating.setRestaurant(restaurant);
	    rating.setCustomer(customer);

	    customer.getRatings().add(rating);
	    
	    customer.getVisitedRestaurants().add(restaurant);

	    customerRepository.save(customer);

	    ratingRepository.save(rating);
		
	}

	public List<Rating> getAllRatings() {
		List<Rating> ratingList = ratingRepository.findAll();
		return ratingList;
	}

	public List<Customer> getAllCustomers() {
		List<Customer> customerList = customerRepository.findAll();
		return customerList;
	}
	
	public List<Customer> allCustomersByVistiedRestaurants(String name){
		Restaurant restaurant = restaurantRepository.findByName(name);
		
		return customerRepository.findByVisitedRestaurants(restaurant);
	}

	public List<Customer> getAllCustomerWithRatingGreaterThan(String restaurantName, double rating) {
		// TODO Auto-generated method stub
		
		Restaurant restaurant = restaurantRepository.findByName(restaurantName);
		
		return customerRepository.getAllCustomerWithRatingGreaterThan(restaurant, rating);
	}

	public Double getAvgRatingByRestaurant(String restaurantName) {
		
		return restaurantRepository.getAvgRatingByRestaurant(restaurantName);
	}

}
