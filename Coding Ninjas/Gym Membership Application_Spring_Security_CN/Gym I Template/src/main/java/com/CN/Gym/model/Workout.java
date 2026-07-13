package com.CN.Gym.model;



import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

/*
    This is the entity class, complete this class by doing the following:
    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */

@Entity
@Table(name="workout")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
    private Long id;
	
	@Column
    private String workoutName;
	
	@Column
    private String description;
	
	@Column
    private String difficultyLevel;
	
	@Column
    private int duration;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;
	

}
