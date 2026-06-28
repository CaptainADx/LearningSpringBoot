package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.EventScheduleDetail;
import com.cn.cnEvent.service.EventScheduleDetailService;

@RestController
@RequestMapping("/eventScheduleDetail")
public class EventScheduleDetailController {

	@Autowired
	EventScheduleDetailService eventScheduleDetailService;
	
	@GetMapping("/{id}")
	public EventScheduleDetail getDetailById(@PathVariable long id) {
		return eventScheduleDetailService.getDetailById(id);
	}
	
	@GetMapping("/all")
	public List<EventScheduleDetail> getAllDetails(){
		return eventScheduleDetailService.getAllDetails();
	}
	
	@PostMapping("/save")
	public String saveDetails(@RequestBody EventScheduleDetail details) {
		
		return eventScheduleDetailService.save(details);
	}
}
