package com.cn.cnEvent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnEvent.dal.TicketDAL;
import com.cn.cnEvent.entity.Ticket;

@Service
public class TicketService {
	
	@Autowired
	TicketDAL ticketDal;
	
	
	@Transactional
	public Ticket getTicketById(Long id) {
		Ticket ticket =  ticketDal.getTicketById(id);
		
		
		return ticket;
	}
	
	
	@Transactional
	public List<Ticket> getAllTickets(){
		List<Ticket> allTickets = ticketDal.getAllTicket();
		
		return allTickets;
	}
	
	
	@Transactional
	public List<Ticket> getAllTicketsByAge(Long age){
		List<Ticket> allTicketsByAge = ticketDal.getAllTicketsByAge(age);
		
		
		return allTicketsByAge;
		
	}


	public String save(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketDal.save(ticket);
	}
}
