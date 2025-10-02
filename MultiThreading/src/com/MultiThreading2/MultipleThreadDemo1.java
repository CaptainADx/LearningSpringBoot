package com.MultiThreading2;

public class MultipleThreadDemo1 {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread started ....");
		
		Task2 t = new Task2();
		Thread t1 = new Thread(t);
		
		t1.start();
		
		t1.join();
		
		System.out.println("Count : " + t.getCount());
		
		System.out.println("Main thread end .......");
	}
}
