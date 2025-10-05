package com.geek.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

//DOING THE SAME THING AS EmployeeDao, That was automatic using PersistenceContext... Current one is Manual Example.
public class CacheTest {
	@PersistenceUnit(name="default")
	private EntityManagerFactory emf;
	
	public Employee searchById(int id) {
		EntityManager em = emf.createEntityManager();
		
		Employee e = em.find(Employee.class, id);
		
		e = em.find(Employee.class, id);
		
		return e;
	}
}
