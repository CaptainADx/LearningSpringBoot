package com.geek;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import com.geek.entity.Address;
import com.geek.entity.Employee;
import com.geek.entity.EmployeeDao;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		EmployeeDao dao = ctx.getBean(EmployeeDao.class);
		
//		//The below code is for Adding new Employee (It is temporarily Commented out)
//		Employee e1 = new Employee();
//		Address address = new Address("Chennai", "94a", "123456");
//		e1.setEmpId(104); e1.setEmpName("Albin"); e1.setAddress(address); e1.setSalary(10000000);
//		
//		dao.addNewEmployee(e1);
		
		//The below code is for Adding new Employee (It is temporarily Commented out)
		Employee e1 = new Employee();
		Address address = new Address("Chennai", "94a", "123456");
		e1.setEmpId(105); e1.setEmpName("Shruti"); e1.setAddress(address); e1.setSalary(2000000); 
		dao.addNewEmployee(e1);
		
//		Employee emp = dao.searchById(101);
//		
//		if(emp != null) {
//			System.out.println("----------------- Employee Found -----------------");
//			System.out.println("ID --> " + emp.getEmpId());
//			System.out.println("Door No --> " + emp.getAddress().getDoorNo());
//			System.out.println("PinCode --> " + emp.getAddress().getPinCode());
//			System.out.println("Place Name --> " + emp.getAddress().getPlaceName());
//			System.out.println("Name --> " + emp.getEmpName());
//			System.out.println("Salary --> " + emp.getSalary());
//		} else {
//			System.out.println("Employee Does Not Exist ! ! !"); 
//		}
		
		List<Employee> emps = dao.getAllEmployees();
		emps.forEach(e -> System.out.println(e));
	}

}
