package com.example.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.EmployeeDao;
import com.example.demo.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
 
	
	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public List<Employee> getEmps(){
		
		return empDao.getAllEmps();
		
	}

	@Override
	public Employee addNewEmployee(Employee e) {
		
		return empDao.addNewEmp(e);
	}
}
