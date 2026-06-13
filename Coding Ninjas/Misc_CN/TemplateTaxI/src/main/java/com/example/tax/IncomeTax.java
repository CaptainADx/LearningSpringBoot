package com.example.tax;

public class IncomeTax implements Tax{
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
	
	IncomeTax(){
		this.taxType = "income";
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
		if(taxableAmount >= 0 && taxableAmount <= 300000) {
			taxAmount = 0;
		}
		else if(taxableAmount >= 300001 && taxableAmount <= 600000) {
			taxAmount = taxableAmount * ((double)5/100);
		}
		else if(taxableAmount >= 600001 && taxableAmount <= 900000) {
			taxAmount = taxableAmount * ((double)10/100);
		}
		else if(taxableAmount >= 900001 && taxableAmount <= 1200000) {
			taxAmount = taxableAmount * ((double)15/100);
		}
		else if(taxableAmount >= 1200001 && taxableAmount <= 1500000) {
			taxAmount = taxableAmount * ((double)20/100);
		}
		else if(taxableAmount > 1500000) {
			taxAmount = taxableAmount * ((double)30/100);
		}
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
		System.out.println("Hi, your income tax is paid");
		
	}

}
