package com.example.Vaccination;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@SpringBootApplication
public class VaccinationApplication {

    public static void main(String[] args) {

        /*
		You need to complete this application as mentioned in the problem 
		statement build your own logic and perform the following tasks.

		 Tasks:
		1. Fetch context from ApplicationContext.xml and initiate Scanner.
		2. Fetch vaccine and User type choice.
		3. Get the required bean from context.
		4. Get the appointment details form user
		5. Display the appointment details
		6. Run the loop again to book for another user or else exit.
		 */

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Welcome to the Vaccination Application");
    	
    	while(true) {
    		
    		System.out.println("Please choose your vaccine preference:");
        	System.out.println("1. Covid");    	
        	System.out.println("2. Polio");
        	System.out.println("3. Typhoid");
        	
        	if(!sc.hasNextInt()) {
        		break;
        	}
        	
        	int choice = sc.nextInt();
        	sc.nextLine();
        	
        	String vaccineType = "";
        	
        	switch(choice) {
	        	case 1 -> vaccineType = "Covid";
	            case 2 -> vaccineType = "Polio";
	            case 3 -> vaccineType = "Typhoid";
	            default -> {
                    System.out.println("Invalid Choice");
                    continue;
                }
        	}
        	
        	System.out.println("Whom do you want to vaccinate");

            System.out.println("1. Father");
            System.out.println("2. Mother");
            System.out.println("3. Self");
            System.out.println("4. Spouse");
            System.out.println("5. Exit");
            
            if(!sc.hasNextInt()) {
                break;
            }
            
            int userChoice = sc.nextInt();
            sc.nextLine();
            
            String userType = "";
            
            switch(userChoice) {

	            case 1 -> userType = "father";
	            case 2 -> userType = "mother";
	            case 3 -> userType = "self";
	            case 4 -> userType = "spouse";
	
	            case 5 -> {
	                System.out.println("Exiting...");
	                return;
	            }
	
	            default -> {
	                System.out.println("Invalid Choice");
	                continue;
	            }
	        }
            
            
            User user = (User) context.getBean(userType+vaccineType);
            if(user.IsVaccinated()) {

                System.out.println("User is already Vaccinated");
            }

            else {

                System.out.println("Please enter " +
                        userType.substring(0,1).toUpperCase()
                        + userType.substring(1)
                        + " details:");

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Age: ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Appointment date (YYYY-MM-DD): ");
                String date = sc.nextLine();

                System.out.print("Appointment time (HH:MM AM/PM): ");
                String time = sc.nextLine();

                System.out.print("Appointment location: ");
                String location = sc.nextLine();

                TimeAndLocation timeAndLocation =
                        new TimeAndLocation();
                
                timeAndLocation.setDate(date);
                timeAndLocation.setLocation(location);
                timeAndLocation.setTimeSlot(time);


                user.setUserDetails(name, age, timeAndLocation);

                user.setAppointment();
            }

            System.out.println(
                    "Do you want to register for someone Else");

            System.out.println("1. Yes");
            System.out.println("2. No");

            if(!sc.hasNextInt()) {
                break;
            }

            int again = sc.nextInt();
            sc.nextLine();

            if(again == 2) {
                break;
            }
        }

        sc.close();
        context.close();
    }
}