package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Event;

@Repository
public class EventDALImpl implements EventDAL{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Event getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Event.class, id);
	}

	@Override
	public List<Event> getAllEvents() {
		Session session = entityManager.unwrap(Session.class);
		List<Event> allEvents = session.createQuery("FROM Event e", Event.class).getResultList();
		return allEvents;
	}

	@Override
	public String save(Event item) {
		Session session = entityManager.unwrap(Session.class);
		session.save(item);
		return "The event was saved successfully.";
	}

	@Override
	public String deleteEvent(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Event event = session.get(Event.class, id);
		session.delete(event);
		return "The event was deleted successfully.";
	}

	@Override
	public String updateEvent(Event event) {
		Session session = entityManager.unwrap(Session.class);
		Event updatedEvent = session.get(Event.class, event.getId());
		
		updatedEvent.setName(event.getName());
		updatedEvent.setDescription(event.getDescription());
		session.update(updatedEvent);
		
		
		return  "Event is updated successfully";
	}

	
}
