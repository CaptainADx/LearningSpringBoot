package com.codingninjas.jpaqueries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.codingninjas.jpaqueries.entities.Grade;
import com.codingninjas.jpaqueries.entities.Student;

public interface GradeRepository extends JpaRepository<Grade, Integer> {
	
	/*
	   Write a Native Query to fetch the average of grades of a given
	   Student.
	 */
	
	@Query(value="Select Avg(g.marks) from grade g where g.student_id = ?1", nativeQuery=true)
	Double getAverageGradesOfStudent(int id);
}
