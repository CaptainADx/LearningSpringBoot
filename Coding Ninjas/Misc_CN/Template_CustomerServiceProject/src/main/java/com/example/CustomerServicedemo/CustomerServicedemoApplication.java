package com.example.CustomerServicedemo;

import java.util.*;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Customers.CustomerCare;

@SpringBootApplication
public class CustomerServicedemoApplication {

	public static void main(String[] args) {

		/*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

			 Tasks:
		 *  1. Load the beans from ApplicationContext.xml
		 *  2. Display all the departments available and get the input from user.
		 *  3. Get the message from user and store it into the respective department.
		 *  
		 */
		Scanner sc =new Scanner(System.in);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		System.out.println("Welcome to our Customer Care Application");
		System.out.print("Please enter your name: ");
		String name = sc.nextLine();
		
		
		System.out.println("Thanks for reaching us "+ name);
		System.out.println("Please select a department to connect to: ");
		System.out.println("1. Payment Department\n2. Query Department\n3. Sales Department\n0. Exit");
		
		int choice = sc.nextInt();
		
		CustomerCare customer = null;
		
		switch(choice) {
			case 1 -> {
				customer = (CustomerCare) context.getBean("paymentDepartment");
				break;
			}
			case 2 -> {
				customer = (CustomerCare) context.getBean("queryDepartment");
				break;
			}
			case 3 -> {
				customer = (CustomerCare) (CustomerCare) context.getBean("salesDepartment");
				break;
			}
			case 0 -> {
				System.out.println("Exiting...");
				sc.close();
				context.close();
				return;
			}
			default -> {
				System.out.println("Invalid Choice");
				return;
			}
		}
		
		customer.setCustomerName(name);
		customer.getService();
		
		String issue = sc.nextLine();

		customer.setProblem(issue);
		
		
		customer.getProblem();
		
		
	}
	
}
