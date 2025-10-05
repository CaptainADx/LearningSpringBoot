package com.geek.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.geek.entity.Department;
import com.geek.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Department addNewDepartment(Department d) {
		em.persist(d);
		return d; 
	}
	@Override
	public Employee addNewEmployee(Employee e, int id) {
		
		Department d = em.find(Department.class, id);
		if(d != null) {
			List<Employee> emps = d.getAllEmps();
			
			if(emps == null) {
				emps = new ArrayList<>();
				
			}
			emps.add(e);
			System.out.println("Employee Added");
		}
		return e;
	}
	
	@Override
	public List<Employee> getAllEmployeesByDeptId(int deptId) {
		Department d = em.find(Department.class, deptId);
		List<Employee> emps = null;
		if(d != null) {
			emps = d.getAllEmps();
		}
			
		
		return emps;
	}
}
