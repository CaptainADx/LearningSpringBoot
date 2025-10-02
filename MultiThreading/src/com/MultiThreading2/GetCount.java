package com.MultiThreading2;

public class GetCount {
	public static void main(String[] args) throws InterruptedException {
		Counter c = new Counter();
		
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		
		t1.start(); t2.start(); t3.start();
		
		t1.join(); t2.join(); t3.join();
		
		
		System.out.print("Count : " + c.getCount());
	}
}
