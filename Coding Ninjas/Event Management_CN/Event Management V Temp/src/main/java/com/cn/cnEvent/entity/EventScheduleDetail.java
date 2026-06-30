package com.cn.cnEvent.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "event_schedule_detail")
public class EventScheduleDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private LocalDateTime startTime;
	
	@Column
	private LocalDateTime endTime;
	
	@Column
	private String location;
	
	@OneToOne(mappedBy = "eventScheduleDetail")
	@JsonIgnore
	private Event event;
	
	public EventScheduleDetail() {
		
	}

	public EventScheduleDetail(LocalDateTime startTime, LocalDateTime endTime, String location) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
}
