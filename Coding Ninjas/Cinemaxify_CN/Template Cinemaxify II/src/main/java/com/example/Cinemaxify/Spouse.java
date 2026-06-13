package com.example.Cinemaxify;

public class Spouse implements User{

    private String name;
    private String memberName = "spouse";
    private int age;
    private Long contact;
    private String address;
    /**
     1. Add attribute private Plan plan.

     2. Create a parameterized constructor as shown below:

        public Spouse(Plan plan)    {

        It accepts a Plan parameter and assigns
        it to the class plan attribute.

            }

     **/
    
    private Plan plan;
    
    public Spouse(Plan plan) {
    	this.plan = plan;
    }


    @Override
    public void setUserDetails(String name, int age, Long contact, String address) {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    @Override
    public void getUserDetails() {
        System.out.println("Hello " + name + " you have entered the following details:");
        System.out.println("age: " +age + "\ncontact: " + contact + "\naddress: " +address);
		System.out.println("You have selected a " + getUserPlan().getPlanName() + " plan for " + memberName);
    }

    // 3. Override the Plan getUserPlan(): It returns the plan attribute
    
    @Override
    public Plan getUserPlan() {
    	return plan;
    }

}
