package com.example.demo;

public class ShortTable implements Table {
	double height;
	double length;
	
	public ShortTable(){
		height = 15.5;
		length = 25.5;
	}
	@Override
	public String showDetails() {
		// TODO Auto-generated method stub
		return "The table has height: " + this.height + " and Length: " + this.length;
	}

}
