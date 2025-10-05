package com.geek.dao;

import java.util.List;

import com.geek.entity.Department;
import com.geek.entity.Employee;

public interface EmployeeDao {
	public Department addNewDepartment(Department d);
	public Employee addNewEmployee(Employee e, int id);
	public List<Employee> getAllEmployeesByDeptId(int deptId);
}
