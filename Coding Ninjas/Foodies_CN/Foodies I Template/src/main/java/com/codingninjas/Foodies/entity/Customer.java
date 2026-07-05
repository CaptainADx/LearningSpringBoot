package com.codingninjas.Foodies.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="customers")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	int id;
	
	@Column
	String name;
	
	@OneToMany(mappedBy = "customer")
	List<Rating> ratings;
	
	@ManyToMany
	@JoinTable(
		    name = "customer_restaurant",
		    joinColumns = @JoinColumn(name = "customer_id"),
		    inverseJoinColumns = @JoinColumn(name = "restaurant_id")
		)
	List<Restaurant> visitedRestaurants;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Restaurant> getVisitedRestaurants() {
		return visitedRestaurants;
	}

	public void setVisitedRestaurants(List<Restaurant> visitedRestaurants) {
		this.visitedRestaurants = visitedRestaurants;
	}
	
	
	
}
