package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class DBConnection {
	
	public Connection getConnectionWithMySql()  {
		Connection conn = null;
		try {
			//Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Create connection object
			String url = "jdbc:mysql://localhost:3306/JBDL187";
			
			conn = DriverManager.getConnection(url, "root", "root");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
