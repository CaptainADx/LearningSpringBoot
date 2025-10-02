package com.LearningThreads;

public class SynchronizationExample {
	public static void main(String[] args) throws InterruptedException {
		Bank bank = new Bank();
		Thread upi = new Thread(bank, "upi");
		Thread atm = new Thread(bank, "atm");
		
		upi.start(); atm.start();
		
		upi.join(); atm.join();
		
		System.out.println("Final Balance " + bank.getBalance());
	}
}


class Bank implements Runnable {
	private float balance = 5000;
	public void run() {
		debit(3000);
	}
	
	private void debit(float debitAmount) {
		if(balance >= 3000) {
			System.out.println(Thread.currentThread().getName() + " Ready to debit.......");
			
			try {
				wait(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance -= debitAmount;
			System.out.println(Thread.currentThread().getName() + " Transaction Success");
		} else {
			System.out.println(Thread.currentThread().getName() + " Insufficient Funds");
		}
	}
	
	public float getBalance() {
		return balance;
	}
}