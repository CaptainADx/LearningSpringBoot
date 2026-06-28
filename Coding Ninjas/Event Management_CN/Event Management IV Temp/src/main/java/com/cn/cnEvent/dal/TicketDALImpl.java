package com.cn.cnEvent.dal;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnEvent.entity.Ticket;

@Repository
public class TicketDALImpl implements TicketDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Ticket getTicketById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		
		Ticket ticket = session.get(Ticket.class, id);
		
		return ticket;
	}

	@Override
	public List<Ticket> getAllTicket() {
		Session session = entityManager.unwrap(Session.class);
		
		List<Ticket> allTickets = session.createQuery("From Ticket t", Ticket.class).getResultList();
		
		return allTickets;
	}

	@Override
	public List<Ticket> getAllTicketsByAge(Long age) {
		Session session = entityManager.unwrap(Session.class);
		
		List<Ticket> allTicketsByAge = session.createQuery("From Ticket t where t.person.age < :age", Ticket.class).setParameter("age", age).getResultList();
		
		return allTicketsByAge;
	}

}
