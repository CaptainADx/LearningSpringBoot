package com.example.dbcTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbcTest.dal.StudentDAL;
import com.example.dbcTest.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
	
	
	@Autowired
	StudentDAL studentDAL;
	

	@Transactional
	public void add(Student student) {
		studentDAL.save(student);
	}
}
