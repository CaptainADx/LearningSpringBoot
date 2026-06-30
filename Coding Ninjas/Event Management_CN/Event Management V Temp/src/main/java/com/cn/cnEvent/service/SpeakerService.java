package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.SpeakerDAL;
import com.cn.cnEvent.entity.Speaker;
import com.cn.cnEvent.exception.ElementAlreadyExistException;
import com.cn.cnEvent.exception.NotFoundException;

@Service
@Transactional
public class SpeakerService {
	@Autowired
	SpeakerDAL speakerDal;
	
	public Speaker getSpeakerById(Long id) {
		Speaker speaker = speakerDal.getById(id);
		
		return speaker;
	}

	public List<Speaker> getAllSpeakers() {
		// TODO Auto-generated method stub
		List<Speaker> speakers = speakerDal.getAllSpeaker();
//		
//		if(speakers.isEmpty()) {
//			throw new NotFoundException("No Speakers Found");
//		}
		
		return speakers;
	}

	public List<Speaker> getAllSpeakerByEventCountAndExperience(Long eventCount, Long experience) {
		// TODO Auto-generated method stub
		List<Speaker> speakers = speakerDal.getAllSpeakerByEventCountAndExperience(eventCount, experience);
		
//		if(speakers.isEmpty()) {
//			throw new NotFoundException("Speakers Not Found");
//		}
		
		return speakers;
	}
	

	public void addSpeakerToEvent(Long speakerId, Long eventId) {
//		 TODO Auto-generated method stub
		
		speakerDal.addSpeakerToEvent(eventId, speakerId);
	}

	public String save(Speaker speaker) {
//		List<Speaker> speakers = getAllSpeakers();
		
		return speakerDal.save(speaker);
	}
	
	
	
	

}
