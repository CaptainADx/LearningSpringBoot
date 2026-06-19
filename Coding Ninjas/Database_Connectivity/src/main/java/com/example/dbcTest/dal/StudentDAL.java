package com.example.dbcTest.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dbcTest.entity.Student;

import jakarta.persistence.EntityManager;

@Repository
public class StudentDAL {
	
	@Autowired
	EntityManager entityManager;
	
	public void save(Student student) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(student);
	}
	
	
	
}
