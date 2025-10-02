package com.example;

public class Main {
	public static void main(String[] args) {
		UserDataProvider dbp1 = new UserDatabaseProvider("sql");
		UserManager manager1 = new UserManager(dbp1);
		
		System.out.println(dbp1.getUserDetails());
		
		
	}
}	
