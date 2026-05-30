package com.example.Cinemaxify;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;
// 1. Beginner Code Template is already provided to you.
// 2. Just follow the below task to complete the execution of main application.
@SpringBootApplication
public class CinemaxifyApplication {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Cinemaxify Application");
		System.out.println("Please select the member you want the plan for:");
		System.out.println("1. Self\n2. Spouse");
		String userType = "";
		
		int userChoice = scanner.nextInt();
		scanner.nextLine();
		
		
		switch (userChoice) {
		
		  case 1 -> {
			  // a. Set userType according to the userChoice.
			  userType = "self";
			  break;
		  }
		  
		  case 2 -> {
			  // b. Set userType according to the userChoice.
			  userType = "spouse";
			  break;
		  }
		  
		  case 3 -> {
			  // c. Print "Exiting..." and return
			  System.out.println("Exiting...");
			  context.close();
			  scanner.close();
			  return;
		  }
		  
		  default -> {
			  // d. Print "Invalid choice." and return.
			  System.out.println("Invalid choice");
			  context.close();
			  scanner.close();
			  return;

		  }
		}
		
		// e. Pick the user bean using context.getBean().
			User user = (User) context.getBean(userType);
			
		// f. Take input for User details i.e. name , age, address etc.
			System.out.println("Please enter your name: ");
			String name = scanner.nextLine();
			
			System.out.println("Please enter your age: ");
			int age = scanner.nextInt();
			
			System.out.println("Please enter your contact: ");
			Long contact = scanner.nextLong();
			
			System.out.println("Please enter your name: ");
			String address = scanner.nextLine();

		// g. Set the above fetched details into the user by using appropriate method.
			
			user.setUserDetails(name, age, contact, address);

		// h. finally print the details by using appropriate method.
			user.getUserDetails();
			

			context.close();
			scanner.close();
		}
	}