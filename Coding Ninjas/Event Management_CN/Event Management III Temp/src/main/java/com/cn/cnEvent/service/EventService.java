package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.EventDAL;
import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class EventService {

	@Autowired
	EventDAL eventDAL;

	@Transactional
	public Event getEventById(Long id) {
		
		if(id==null || id <= 0){
			throw new InvalidInputException("No event found with id:  "+id);
		}
		

		Event event=eventDAL.getById(id);
		
		if(event == null){
		    throw new NotFoundException("No event found with id: " + id);
		}

		return event;
	}

	@Transactional
	public List<Event> getAllEvents() {
	    return eventDAL.getAllEvents();
	}

	@Transactional
	public String saveEvent(Event newEvent) {

	    if (newEvent == null) {
	        throw new InvalidInputException("Input is invalid.");
	    }

	    if (newEvent.getId() != null) {

	        Event existingEvent = eventDAL.getById(newEvent.getId());

	        if (existingEvent != null) {
	            throw new ElementAlreadyExistException(
	                    "Event with id " + newEvent.getId() + " already exists.");
	        }
	    }

	    return eventDAL.save(newEvent);
	}

	@Transactional
	public String delete(Long id) {

	    if (id == null || id<=0) {
	        throw new InvalidInputException("Input is invalid.");
	    }

	    Event event = eventDAL.getById(id);

	    if (event == null) {
	        throw new InvalidInputException("Event with id " + id + " does not exist.");
	    }

	    return eventDAL.delete(id);
	}
	
	
	@Transactional
	public String update(Event updateEvent) {

	    if (updateEvent == null || updateEvent.getId() == null) {
	        throw new InvalidInputException("Input is invalid.");
	    }

	    Event existingEvent = eventDAL.getById(updateEvent.getId());

	    if (existingEvent == null) {
	        throw new NotFoundException(
	                "Event with id " + updateEvent.getId() + " does not exist.");
	    }

	    return eventDAL.update(updateEvent);
	}
	

	@Transactional
	public EventScheduleDetail getEventScheduleDetailByEventId(Long id) {
		if(id == null || id <= 0) {
			throw new InvalidInputException("Input is invalid");
		}
		
		EventScheduleDetail esd = eventDAL.getEventScheduleDetailByEventId(id);
		
		if(esd == null) {
			throw new NotFoundException("Element with Id: " + id + " does not exist.") ;
		}
		
		return esd;
	}

	@Transactional
	public String deleteEventScheduleDetailByEventId(Long eventId) {
//		if(eventId == null || eventId<= 0) {
//			throw new InvalidInputException("Input is invalid");
//		}
//		Event event =  eventDAL.getById(eventId);
//		if(event == null) {
//			throw new NotFoundException("Event with id " + eventId + " does not exist.");
//		}
//		
//		if(event.getEventScheduleDetail() == null) {
//			 return "The eventSchedule was deleted successfully.";
//		}
		
		return eventDAL.deleteEventScheduleDetailByEventId(eventId);
		
		
	}

	@Transactional
	public List<Event> getEventByLocation(String location) {
		if(location == null) {
			throw new InvalidInputException("Input is invalid");
		}
		List<Event> events = eventDAL.getEventByLocation(location);
		if (events.isEmpty()) {
	        throw new NotFoundException(
	                "No events found for location: " + location);
	    }

	    return events;
	}
}
