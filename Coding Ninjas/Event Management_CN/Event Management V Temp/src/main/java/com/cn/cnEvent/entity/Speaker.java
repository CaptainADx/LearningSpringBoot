package com.cn.cnEvent.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "speakers")
public class Speaker {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Long id;
	
	@Column
	String name;
	
	@Column
	Long experience;
	
	@ManyToMany(mappedBy = "speakers")
//	@JoinTable(name="event_speaker", joinColumns = @JoinColumn(name="speaker_id"), inverseJoinColumns = @JoinColumn(name="event_id"))
//	@JsonManagedReference
	private List<Event> events;
	
	
	public Speaker() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getExperience() {
		return experience;
	}

	public void setExperience(Long experience) {
		this.experience = experience;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	
}
