package com.example.tax;

public class PropertyTax implements Tax{
    /*
    1. Create the following attributes.
        a. taxableAmount (double)
        b. taxAmount (double)
        c. isTaxPayed (boolean)
    2. Make this class an implementation of Tax interface and override the interface methods.
    3. Using constructor initialize the isTaxPayed boolean false.
     */
	String taxType;
	double taxableAmount;
	double taxAmount;
	boolean isTaxPayed;
	
	PropertyTax(){
		this.taxType = "property";
		this.isTaxPayed = false;
	}

	@Override
	public void setTaxableAmount(double amount) {
		// TODO Auto-generated method stub
		this.taxableAmount = amount;
		
	}

	@Override
	public void calculateTaxAmount() {
		// TODO Auto-generated method stub
		taxAmount = taxableAmount * ((double)5/100.0);
		
	}

	@Override
	public double getTaxAmount() {
		// TODO Auto-generated method stub
		return taxAmount;
	}

	@Override
	public String getTaxType() {
		// TODO Auto-generated method stub
		return taxType;
	}

	@Override
	public boolean isTaxPayed() {
		// TODO Auto-generated method stub
		return isTaxPayed;
	}

	@Override
	public void payTax() {
		// TODO Auto-generated method stub
		isTaxPayed = true;
		System.out.println("Hi, your property tax is paid");
		
	}
}
