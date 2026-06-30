package com.cn.cnEvent.dal;

import java.util.List;

import com.cn.cnEvent.entity.Speaker;

public interface SpeakerDAL {
	Speaker getById(Long id);
	List<Speaker> getAllSpeaker();
	List<Speaker> getAllSpeakerByEventCountAndExperience(Long eventCount, Long experience);
	
	void addSpeakerToEvent(Long eventId, Long speakerId);
	String save(Speaker speaker);
}
