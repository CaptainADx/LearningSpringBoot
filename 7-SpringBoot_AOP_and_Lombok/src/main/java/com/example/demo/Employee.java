package com.example.demo;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
	
	@Positive(message = "ID must be greater than 0")
	private int empId;
	@NotBlank(message = "Name Cannot be Blank")
	private String empName;
	@NotBlank(message = "Address Cannot be Blank")
	private String address;
	@Min(value = 10000, message = "Salary must be greater than 10000")
	private float salary;
	
	
}
