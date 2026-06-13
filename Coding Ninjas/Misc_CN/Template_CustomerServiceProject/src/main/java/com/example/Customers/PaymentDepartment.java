package com.example.Customers;

/*
     This class is an implementation of a CustomerCare Interface based on the selection 
     in the console the department type is selected.You need to complete this class 
     based on the following tasks.

     Tasks:
       1. Override the methods of CustomerCare Interface:
       2. Build your logic for all the method based on the description given in CustomerCare Interface.
 */
public class PaymentDepartment implements CustomerCare {
	
    private String department= "Payment Department";
    private String customerName;
    private String issue; 
    private double refId;
	@Override
	public String getDepartment() {
		// TODO Auto-generated method stub
		return department;
	}
	@Override
	public void getService() {
		// TODO Auto-generated method stub
		System.out.println("Welcome " + customerName + ", you have reached the" + department);
		System.out.println("How may I assist you with your query inquiry?");
	}
	@Override
	public void setCustomerName(String name) {
		// TODO Auto-generated method stub
		this.customerName = name;
	}
	@Override
	public void setProblem(String problem) {
		// TODO Auto-generated method stub
		issue = problem;
		
	}
	@Override
	public void getProblem() {
		// TODO Auto-generated method stub
		refId = (int)(Math.random() * 1000);
		System.out.println("Dear " + customerName
				+ ", your issue \"" + issue + " \" is registered with "
				+ department);
	} 

}
