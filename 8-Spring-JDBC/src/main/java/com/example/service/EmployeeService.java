package com.example.service;
import java.util.List;

import com.example.demo.Employee;


public interface EmployeeService {
	
	List<Employee> getEmps();
	
	Employee addNewEmployee(Employee e);
}
