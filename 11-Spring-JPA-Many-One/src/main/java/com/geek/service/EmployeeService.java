package com.geek.service;

import java.util.List;

import com.geek.entity.Department;
import com.geek.entity.Employee;

public interface EmployeeService {

	public Department addNewDepartmentService(Department d);

	public Employee addNewEmployeeService(Employee e, int deptId);
	
	public List<Employee> getAllEmployeesByDeptId(int deptId);
}
