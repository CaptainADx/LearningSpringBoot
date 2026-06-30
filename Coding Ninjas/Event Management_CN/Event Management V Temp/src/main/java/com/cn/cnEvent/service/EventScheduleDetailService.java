package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.EventScheduleDetailDAL;
import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.InvalidInputException;
import com.cn.cnEvent.exception.NotFoundException;

@Service
public class EventScheduleDetailService {
	@Autowired
	EventScheduleDetailDAL eventScheduleDetailDal;
	
	@Transactional
	public EventScheduleDetail getDetailById(Long id) {
		if(id == null || id<=0) {
			throw new InvalidInputException("Input is invalid");
		}
		EventScheduleDetail eventScheduleDetail =  eventScheduleDetailDal.getById(id);
		
		if(eventScheduleDetail == null) {
			throw new NotFoundException("Event Schedule Details with id: " + id+ " not found");
		}
		
		return eventScheduleDetail;
	}
	
	
	@Transactional
	public List<EventScheduleDetail> getAllDetails() {
	    return eventScheduleDetailDal.getAllDetails();
	}
	
	
	@Transactional
	public String save(EventScheduleDetail eventScheduleDetail) {
		if(eventScheduleDetail == null) {
			throw new InvalidInputException("Input is invalid");
		}
		
		EventScheduleDetail eventDetail = null;
		if(eventScheduleDetail.getId() != null) {
			eventDetail = eventScheduleDetailDal.getById(eventScheduleDetail.getId());	
		}
		
		if(eventDetail != null) {
			throw new ElementAlreadyExistException("Element with Id: " + eventScheduleDetail.getId() + " already exists.");
		}
		
		return eventScheduleDetailDal.save(eventScheduleDetail);
	}
}
