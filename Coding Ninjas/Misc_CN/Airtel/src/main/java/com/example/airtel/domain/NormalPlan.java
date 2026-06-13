package com.example.airtel.domain;

import org.springframework.stereotype.Component;

@Component
public class NormalPlan implements Plan {
	String data;
	String calls;
	String duration;
	int speed;
	
	
	
	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getCalls() {
		return calls;
	}



	public void setCalls(String calls) {
		this.calls = calls;
	}



	public String getDuration() {
		return duration;
	}



	public void setDuration(String duration) {
		this.duration = duration;
	}



	public int getSpeed() {
		return speed;
	}



	public void setSpeed(int speed) {
		this.speed = speed;
	}



	@Override
	public void createPlan(String data, String calls, String duration, int speed) {
		
		setData(data);
		setCalls(calls);
		setDuration(duration);
		setSpeed(speed);
		
	}
	

}
