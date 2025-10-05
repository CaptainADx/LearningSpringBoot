package com.geek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geek.dao.EmployeeDao;
import com.geek.entity.Department;
import com.geek.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDao empDao;
	
	@Override
	@Transactional
	public Department addNewDepartmentService(Department d) {
		
		return empDao.addNewDepartment(d);
	}

	@Override
	@Transactional
	public Employee addNewEmployeeService(Employee e, int deptId) {
		
		return empDao.addNewEmployee(e, deptId);
	}
 
	@Override
	@Transactional
	public List<Employee> getAllEmployeesByDeptId(int deptId) {
		return empDao.getAllEmployeesByDeptId(deptId);
	}
	
	
	
}
