package com.example.dao;

import com.example.demo.Employee;
import java.util.List;

public interface EmployeeDao {
	public List<Employee> getAllEmps();
	public Employee addNewEmp(Employee e);
}
