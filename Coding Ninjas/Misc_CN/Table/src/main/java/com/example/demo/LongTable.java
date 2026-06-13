package com.example.demo;

public class LongTable implements Table {
	
	double height;
	double length;
	
	public LongTable() {
		this.height = 40.5;
		this.length = 100.5;
	}

	@Override
	public String showDetails() {
		// TODO Auto-generated method stub
		return "The table has height: " + this.height + " and Length: " + this.length;
	}

}
