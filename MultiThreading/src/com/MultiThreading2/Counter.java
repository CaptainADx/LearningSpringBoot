package com.MultiThreading2;

public class Counter implements Runnable{
	int count;
	public void run() {
		for(int i=0; i<10000;i++) {
			synchronized(this) {
				count++;
			}
		}
	}
	
	public int getCount() {
		return count;
	}
}
