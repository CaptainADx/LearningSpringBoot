package com.geek.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name="Department")
@Data
@Table(name="Department_Table")
public class Department {
	@Id
	private int deptId;
	private String deptName;
	
	@OneToMany(mappedBy = "dept")
	private List<Employee> emps;
	
}
