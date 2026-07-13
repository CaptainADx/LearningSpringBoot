package com.CN.Gym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import javax.persistence.*;

import java.util.*;


/*
    This is the entity class, complete this class by doing the following:
    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */
@Entity
@Table(name="gym")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gym {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
    private Long id;
	
	@Column
    private String name;
	
	@Column
    private String address;
	
	@Column
    private Long contactNo;
	
	@Column
    private String membershipPlans;
	
	@Column
    private String facilities;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="gym", fetch = FetchType.EAGER)
	@JsonManagedReference
	List<User> members = new ArrayList<>();
	
}
