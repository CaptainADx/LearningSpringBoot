package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Event;
import com.cn.cnEvent.entity.Speaker;


@Repository
public class SpeakerDALImpl implements SpeakerDAL{
	
	@Autowired
	EntityManager entityManager;

	@Override
	public Speaker getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Speaker speaker = session.get(Speaker.class, id);
		return speaker;
	}
	
	
	@Override
	public List<Speaker> getAllSpeaker() {
		Session session = entityManager.unwrap(Session.class);
		List<Speaker> speakers = session.createQuery("Select s From Speaker s", Speaker.class).getResultList();
		return speakers;
	}
	
	
	@Override
	public List<Speaker> getAllSpeakerByEventCountAndExperience(Long eventCount, Long experience) {
		Session session = entityManager.unwrap(Session.class);
		List<Speaker> speakers = session.createQuery("Select s From Speaker s JOIN  s.events e WHERE s.experience > :experience GROUP BY s HAVING COUNT(e) >= :eventCount", Speaker.class).setParameter("experience", experience).setParameter("eventCount", eventCount).getResultList();
		return speakers;
	}
	
	
	@Override
	public void addSpeakerToEvent(Long eventId, Long speakerId) {
		Session session = entityManager.unwrap(Session.class);
		
		
		Speaker speaker = session.get(Speaker.class, speakerId);
//		
//		if(speaker == null) {
//			throw new NotFoundException("Speaker with id: " + speakerId +" not found");
//		}
//		
		Event event = session.get(Event.class, eventId);
//		
//		if(event == null) {
//			throw new NotFoundException("Event with id: " + eventId +" not found");
//		}
//		
//		
		if(!speaker.getEvents().contains(event)) {
			speaker.getEvents().add(event);
			event.getSpeakers().add(speaker);
		}
		
//		session.save(speaker);
//		session.save(event);
	}
	

	@Override
	public String save(Speaker speaker) {
		Session session = entityManager.unwrap(Session.class);

	    session.save(speaker);

	    return "The speaker was saved successfully.";
	}
}
