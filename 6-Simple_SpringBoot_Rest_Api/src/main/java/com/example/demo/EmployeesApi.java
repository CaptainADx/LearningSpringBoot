package com.example.demo;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.CustomException;
import com.example.service.EmployeeService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/employees")
public class EmployeesApi {
	
	private EmployeeService employeeService;

	public EmployeesApi(EmployeeService employeeService){
		this.employeeService = employeeService;
	}
	
	
	@GetMapping("/test")
	public String test() {
		return "Its Working";
	}
	
	
	@GetMapping(value="/sample", produces= {"application/xml", "application/json"})
	public Employee testEmployee() {
		Employee e = new Employee(101, "Abhijeet", "Bangalore", 8000000);
		return e;
	}
	
	
	@GetMapping(value="/allEmployees", produces = {"application/xml", "application/json"})
	public List<Employee> getAllEmps(){
		List<Employee> e = employeeService.getEmps();
		
		return e;
	}
	
	
	@GetMapping(value="/{id}", produces = {"application/xml", "application/json"})
	public Employee getEmpById(@PathVariable int id) {
		List<Employee> empList = employeeService.getEmps();
		
		Employee emp =  empList.stream().filter((e) -> e.getEmpId() == id).findFirst().orElseThrow(() -> new CustomException("Exception Handled carefully"));
		
		return emp;
	}
	
	
	@PostMapping(produces={"application/json", "application/xml"} , consumes={"application/json", "application/xml"})
	public List<Employee> addEmployee(@Valid @RequestBody Employee e) {
		List<Employee> emps = employeeService.getEmps();
		emps.add(e);
		return emps;
	} 
}
