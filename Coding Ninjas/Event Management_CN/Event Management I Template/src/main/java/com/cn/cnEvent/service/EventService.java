package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;

@Service
@Transactional
public class EventService {
	
	@Autowired
	EventDAL eventDal;
	
	
	public Event getEventById(long id) {
		return eventDal.getById(id);
	}


	public List<Event> getAllEvents() {
		return eventDal.getAllEvents();
	}
	
	public String saveEvent(Event event) {
		return eventDal.save(event);
	}


	public String deleteEventById(Long id) {
		return eventDal.deleteEvent(id);
	}


	public String updateEvent(Event event) {
		return eventDal.updateEvent(event);
	}

}
