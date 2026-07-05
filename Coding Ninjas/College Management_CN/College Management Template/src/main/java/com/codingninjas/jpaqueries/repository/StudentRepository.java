package com.codingninjas.jpaqueries.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.codingninjas.jpaqueries.entities.Student;


public interface StudentRepository extends JpaRepository<Student, Integer> {


	/* TODO:
	   Write the derived query which finds the list of all the students
	   enrolled in a given course.
	 */
	
	List<Student> findAllByCoursesName(String course);
	

}
