package com.geek.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Dept_Emp")
	List<Employee> allEmps;
}
