package com.codingninjas.Foodies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codingninjas.Foodies.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

	Restaurant findByName(String restaurantName);
	
	@Query(value="select AVG(rt.rating) from ratings rt join restaurants r on rt.restaurant_id = r.id where r.name = ?1", nativeQuery=true)
	public Double getAvgRatingByRestaurant(String restaurantName);
}
