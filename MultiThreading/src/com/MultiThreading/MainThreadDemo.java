package com.MultiThreading;

public class MainThreadDemo {
	public static void main(String Args[]) throws InterruptedException {
		System.out.println("Main thread started........");
		
		Thread mainThread = Thread.currentThread();
		mainThread.setPriority(10);
		
		Task1 t = new Task1();
		Thread t1 = new Thread(t);
		t1.setPriority(1);
		t1.start();
		
		for(int i=11; i<=20; i++) {
			System.out.println(i);
			Thread.sleep(1000);
			
		}
		
		System.out.print("Main Thread ends........");
	}
}



