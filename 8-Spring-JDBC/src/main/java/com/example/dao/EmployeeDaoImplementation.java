package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.Employee;

@Repository
public class EmployeeDaoImplementation implements EmployeeDao {
	
	@Autowired
	DBConnection dbConnection;

	@Override
	public List<Employee> getAllEmps() {
		List<Employee> allEmployee = new ArrayList<>();
		
		Connection conn = dbConnection.getConnectionWithMySql();
		
		String query = "SELECT * FROM employees";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("empId");
				String name = rs.getString("empName");
				String address = rs.getString("address");
				float salary = rs.getFloat("salary");
				
				Employee emp = new Employee(id, name, address, salary);
				
				allEmployee.add(emp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allEmployee;
		
	}

	@Override
	public Employee addNewEmp(Employee e) {
		Connection conn = dbConnection.getConnectionWithMySql();
		
		String query = "INSERT INTO employees VALUES(?,?,?,?)";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, e.getEmpId());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getAddress());
			pstmt.setFloat(4, e.getSalary());
			pstmt.executeUpdate();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return e;
	}
	
}
