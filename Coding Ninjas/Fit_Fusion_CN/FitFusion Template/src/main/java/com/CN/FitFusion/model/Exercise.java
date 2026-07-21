package com.CN.FitFusion.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="exercises")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {

//    • Long id
//
//    • String name
//
//    • String description
//
//    • int sets
//
//    • int reps
//
//    • User user (ManyToOne)
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	Long id;
	
	@Column
	String name;
	
	@Column
	String description;
	
	@Column
	int sets;
	
	@Column
	int reps;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	User user;
}
