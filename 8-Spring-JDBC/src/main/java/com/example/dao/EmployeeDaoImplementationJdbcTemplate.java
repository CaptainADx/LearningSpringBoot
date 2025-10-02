package com.example.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.Employee;

@Repository
@Primary
public class EmployeeDaoImplementationJdbcTemplate implements EmployeeDao{
	
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public List<Employee> getAllEmps() {
		 
		
		String query = "Select * from employees";
		List<Employee> empList = template.query(query, new BeanPropertyRowMapper<>(Employee.class));
		return empList;
		
	}

	@Override
	public Employee addNewEmp(Employee e) {
		String query = "INSERT INTO employees VALUES(?, ?, ?, ?)";
		template.update(query,  e.getEmpId(), e.getEmpName(), e.getAddress(), e.getSalary());
		
		return e;
	}

}
