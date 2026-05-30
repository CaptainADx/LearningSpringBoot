package com.example.EventRegistration;

public class MyCollege implements College{

    /*
        1. Create attribute name (string) and initialize it with some default name.

        2. Inject the CollegeEvent dependency using setter injection as shown below:

                public void setEvent(CollegeEvent event) {
                        this.event = event;
                }

        Note: You have to create "CollegeEvent event" object to be able to inject it using
              setEvent method.

        3. Make the class College interface implementation and override the interface methods.
     */
	
	String name;
	CollegeEvent event;
	
	
	
	public MyCollege() {
		this.name = "John";
	}
	
	public void setEvent(CollegeEvent event) {
		this.event = event;
	}

	@Override
	public String getCollegeName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public CollegeEvent getEvent() {
		// TODO Auto-generated method stub
		return event;
	}
	

}
