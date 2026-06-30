package com.cn.cnEvent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;

	@GetMapping("/{id}")
	public Ticket getTicketById(@PathVariable Long id) {
		return ticketService.getTicketById(id);
	}
	
	@GetMapping("/all")
	public List<Ticket> getAllTickets(){
		return ticketService.getAllTickets();
	}
	
	
	@GetMapping("/allByAge/{age}")
	public List<Ticket> getAllTicketsByAge(@PathVariable Long age){
		return ticketService.getAllTicketsByAge(age);
	}
	
	
	@PostMapping(value = "/save", consumes = "application/json")
	public String save(@RequestBody Ticket ticket) {
		return ticketService.save(ticket);
	}
}
