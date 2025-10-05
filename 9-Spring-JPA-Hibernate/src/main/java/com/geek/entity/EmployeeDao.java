package com.geek.entity;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository 
public class EmployeeDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addNewEmployee(Employee e) {
		em.persist(e); // during the Persist State we can change the Properties of the Object
		
//		e.getAddress().setPlaceName("Noida");   //Sample to change the Property...
		System.out.println("Emp is added to DB");
	}
	
	
	@Transactional
	public Employee searchById(int id) {
		Employee emp = em.find(Employee.class, id);
		
		return emp;
	}
	
	@Transactional
	public List<Employee> getAllEmployees(){
		String jpql = "Select emp from Employee emp";
//		Query q = em.createQuery(jpql);
//		We can use this below TypedQuery and Tell Exlicitly the object type, unlike the line above
		TypedQuery<Employee> q = em.createQuery(jpql, Employee.class); 
		List<Employee> emps = q.getResultList();
		return emps;
		
	}
}
