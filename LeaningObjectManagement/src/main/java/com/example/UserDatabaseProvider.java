package com.example;

public class UserDatabaseProvider implements UserDataProvider{
	String databaseName;
	UserDatabaseProvider(String databaseName){
		this.databaseName = databaseName;
	}
	
	@Override
	public String getUserDetails() {
		
		return "User Details from Database : " + databaseName;
	}
	
	
}
