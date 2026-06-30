package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.EventScheduleDetail;


@Repository
public class EventScheduleDetailDALImpl implements EventScheduleDetailDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public EventScheduleDetail getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		
		EventScheduleDetail eventScheduleDetail = session.get(EventScheduleDetail.class, id);
		
		return eventScheduleDetail;
	}

	@Override
	public List<EventScheduleDetail> getAllDetails() {
		Session session = entityManager.unwrap(Session.class);
		
		List<EventScheduleDetail> eventScheduleList = session.createQuery("From EventScheduleDetail e", EventScheduleDetail.class).getResultList();
		
		return eventScheduleList;
	}

	@Override
	public String save(EventScheduleDetail eventScheduleDetail) {
		
		Session session = entityManager.unwrap(Session.class);
		

	    session.persist(eventScheduleDetail);

	    return "The eventScheduleDetails was saved successfully";
	}

}
