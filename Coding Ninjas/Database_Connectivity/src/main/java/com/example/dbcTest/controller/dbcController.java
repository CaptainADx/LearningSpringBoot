package com.example.dbcTest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbcTest.entity.Student;
import com.example.dbcTest.service.StudentService;

@RestController
@RequestMapping("/student")
public class dbcController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student student ) {
		studentService.add(student);
		return "Student Saved";
	}
}
