package com.example.EventRegistration;
import java.util.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@SpringBootApplication
public class EventRegistrationApplication {

	public static void main(String[] args) {
		// Import scanner and take ClassPathXmlApplicationContext.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome to the Graduation Ceremony Registration Application");
		
		// Take the college event bean from the application context.
		CollegeEvent event = (CollegeEvent) context.getBean("event");
		
		// Print the event details.
		event.printEventDetails();
		

		while (true) {
			System.out.println("Do you want to register for the ceremony\n1. Yes\n2. No");
			if (!scanner.hasNextLine()) break;
			String inputLine = scanner.nextLine().trim();
			int input;
			try {
			input = Integer.parseInt(inputLine);
			} catch (Exception e) {
			System.out.println("Invalid Choice");
			continue;
			}
			if (input == 1) {
			System.out.println("Enter your name:");
			if (!scanner.hasNextLine()) break;
			String name = scanner.nextLine().trim();

			
			    System.out.println("Enter your department:");
			    if (!scanner.hasNextLine()) break;
			    String department = scanner.nextLine().trim();

			    System.out.println("Enter your batch:");
			    if (!scanner.hasNextLine()) break;
			    String batchLine = scanner.nextLine().trim();
			    int batch;
			    try {
			        batch = Integer.parseInt(batchLine);
			    } catch (Exception e) {
			        System.out.println("Invalid batch. Please enter a number.");
			        continue;
			    }
			    Attendee studentAttendee = (Attendee) context.getBean("student");
			    studentAttendee.setAttendeeDetails(name, department, batch);
			    event.registerStudent(studentAttendee);
			    studentAttendee.printRegistrationConfirmation();
			} else if (input == 2) {
			    break;
			} else {
			    System.out.println("Invalid Choice");
			}
			}

		// Get the number of attendees and print along with the statement below
		System.out.println("No. of attendees registered are: " + event.getAttendeeCount());
		System.out.println("The list of attendees are:");
		// Print all the attendee names with their reference ids as given in the sample output..
		List<Attendee> attendees = event.getAllAttendees();
		
		for(Attendee attendee: attendees) {
			System.out.println(attendee.getAttendeeName() + "Reference id: "+ attendee.toString());
		}
		
		scanner.close();
		context.close();
	}

}
