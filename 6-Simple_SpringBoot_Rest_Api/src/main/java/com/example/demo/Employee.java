package com.example.demo;



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	
	@Positive(message = "ID must be greater than 0")
	private int empId;
	@NotBlank(message = "Name Cannot be Blank")
	private String empName;
	@NotBlank(message = "Address Cannot be Blank")
	private String address;
	@Min(value = 10000, message = "Salary must be greater than 10000")
	private float salary;
	
	public Employee() {
		
	}
	
	public Employee(int empId, String empName, String address, float salary) {
        this.empId = empId;
        this.empName = empName;
        this.address = address;
        this.salary = salary;
    }

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
	
}
