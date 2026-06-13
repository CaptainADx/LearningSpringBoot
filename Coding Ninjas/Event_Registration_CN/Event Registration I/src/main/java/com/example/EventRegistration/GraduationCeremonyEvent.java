package com.example.EventRegistration;

import java.util.ArrayList;
import java.util.List;

public class GraduationCeremonyEvent implements CollegeEvent{

    /*
    1. Create the following attributes:
        a. name (initialize it as "Graduation Ceremony".
        b. address (String)
        c. time (String)
        d. date (String)
        e. count (int) (initially 0)
        f. eventAttendees (List of Attendee)
        NOTE: Initialize the address, time and date attributes with some values.
    2. Inject Attendee with attribute name "attendee" with setter injection.
    3. Make this class an implementation of CollegeEvent interface and override the interface methods.
    */
	
	String name = "Graduation Ceremony";
	String address;
	String time;
	String date;
	int count;
	List<Attendee> eventAttendee;
	
	Attendee attendee;
	
	public GraduationCeremonyEvent() {
		// TODO Auto-generated constructor stub
		this.address ="Auditorium";
		this.time = "10 AM";
		this.date = "12 Nov 2023";
		count = 0;
		eventAttendee = new ArrayList<Attendee>();
	}
	
	public void setAttendee(Attendee attendee) {
		this.attendee = attendee;
	}

	@Override
	public void registerStudent(Attendee user) {
		// TODO Auto-generated method stub
		setAttendee(user);
		this.eventAttendee.add(attendee);
		count++;
	}

	@Override
	public List<Attendee> getAllAttendees() {
		// TODO Auto-generated method stub
		return eventAttendee;
	}

	@Override
	public void printEventDetails() {
		// TODO Auto-generated method stub
		System.out.println("The Graduation Ceremony details are as follows:"); 

	    System.out.println("Venue: " + this.address); 

	    System.out.println("Time: " + this.time); 

	    System.out.println("Date: " + this.date);
	}

	@Override
	public int getAttendeeCount() {
		return this.count;
	}

}
