package com.geek.entity;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity(name="Employee")
@Data
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="Employee_Table")
public class Employee {
	@Id
	@EqualsAndHashCode.Include
	private int empId;
	private String empName;
	@Embedded
	private Address address;
	private float salary;

}

