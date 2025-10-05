package com.geek.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.geek.entity.Department;
import com.geek.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

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
	public Employee addNewEmployee(Employee e, int deptId) {
		Department d = em.find(Department.class, deptId);
		if(d!=null) {
			e.setDept(d);
			em.persist(e);
			System.out.println("New Employee Added");
			
		}
		System.out.println("Department Does not Exist");
		return e;
		
	}
	
	@Override
	public List<Employee> getAllEmployeesByDeptId(int deptId) {
		String jpql = "Select emp from Employee emp where emp.dept.deptId = :departmentId";
		Query q = em.createQuery(jpql);
		q.setParameter("departmentId", deptId);
		List<Employee> empList = q.getResultList();
		return empList;
	}
}
