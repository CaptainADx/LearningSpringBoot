package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name="Department")
@Data
@Table(name="Department_Table")
public class Department {
	@Id
	private int deptId;
	private String deptName;
	
	
}
