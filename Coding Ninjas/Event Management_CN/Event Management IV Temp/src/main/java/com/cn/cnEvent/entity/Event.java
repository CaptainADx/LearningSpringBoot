package com.cn.cnEvent.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", nullable = false)
	private String description;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "event_schedule_detail_id")
    private EventScheduleDetail eventScheduleDetail;
	
	
	@OneToMany(mappedBy="event", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Ticket> tickets;
	
	public Event() {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public EventScheduleDetail getEventScheduleDetail() {
		return eventScheduleDetail;
	}

	public void setEventScheduleDetail(EventScheduleDetail eventScheduleDetail) {
		this.eventScheduleDetail = eventScheduleDetail;
	}

	public List<Ticket> getTickets() {
		
		return tickets;
	}

	public void setTickets(List<Ticket> ticket) {
		this.tickets = ticket;
	}
	
	
	
	

}
