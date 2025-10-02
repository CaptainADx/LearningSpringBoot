package com.MultiThreading2;

public class Task2 implements Runnable{
	private int count=0;
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			System.out.println(i);
			count++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	int getCount() {
		return count;
	}
}
