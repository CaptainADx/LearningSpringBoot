package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.EventScheduleDetail;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EventDALImpl implements EventDAL {

    @Autowired
    EntityManager entityManager;

    @Override
    public Event getById(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        Session session = entityManager.unwrap(Session.class);
        List<Event> allEvents = session.createQuery("SELECT e FROM Event e", Event.class).getResultList();
        return allEvents;
    }

    @Override
    public String save(Event event) {
        Session session = entityManager.unwrap(Session.class);
        session.save(event);
        return "The event was saved successfully.";
    }

    @Override
    public String delete(Long id) {
        Session session = entityManager.unwrap(Session.class);
        Event event = session.get(Event.class, id);
        session.delete(event);
        return "The event was deleted successfully";
    }

    @Override
    public String update(Event updateEvent) {
        Session session = entityManager.unwrap(Session.class);
    	Event currentEvent = session.get(Event.class, updateEvent.getId());

    	currentEvent.setName(updateEvent.getName());
    	currentEvent.setDescription(updateEvent.getDescription());

    	if (updateEvent.getEventScheduleDetail() != null) {
    	    currentEvent.setEventScheduleDetail(updateEvent.getEventScheduleDetail());
    	}
        return "Event is updated successfully";
    }

	@Override
	public EventScheduleDetail getEventScheduleDetailByEventId(Long id){
		Session session = entityManager.unwrap(Session.class);
		
		
		Event currEvent = session.get(Event.class, id);

		
		return currEvent.getEventScheduleDetail();
		
	}

	@Override
	public String deleteEventScheduleDetailByEventId(Long eventId) {

		Session session = entityManager.unwrap(Session.class);
	    Event currEvent = session.get(Event.class, eventId);

	    if (currEvent != null && currEvent.getEventScheduleDetail() != null) {
	        // Setting this to null with orphanRemoval = true tells Hibernate to delete the record from the DB
	        currEvent.setEventScheduleDetail(null); 
	    }

	    return "The eventSchedule was deleted successfully";
		
	}

	@Override
	public List<Event> getEventByLocation(String location) {
		Session session = entityManager.unwrap(Session.class);
		
		List<Event> eventListByLocation = session.createQuery("SELECT e FROM Event e JOIN e.eventScheduleDetail esd WHERE LOWER(esd.location) LIKE LOWER(:location)", Event.class).setParameter("location", "%" + location + "%").getResultList();
				
		return eventListByLocation;
	}

}
