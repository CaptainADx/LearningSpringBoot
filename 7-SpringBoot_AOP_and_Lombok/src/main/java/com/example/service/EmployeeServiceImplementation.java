package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
 
	List<Employee> allEmployees = new ArrayList<>();
	{
		allEmployees.add( new Employee(101, "Abhijeet", "Bangalore", 800000));
		allEmployees.add( new Employee(102, "Shruti", "Gurugram", 500000));
		allEmployees.add( new Employee(103, "Karan", "Panchkula", 500000));
		allEmployees.add( new Employee(104, "Abhishek", "Panchkula", 500000));
		allEmployees.add( new Employee(105, "Usman", "Lucknow", 700000));
	}
	
	
	@Override
	public List<Employee> getEmps(){
		
		System.out.println("Getting All Employees Service Method");
		
		return allEmployees;
		
	}
}
