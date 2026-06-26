package com.cn.cnkart.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnkart.entity.Order;

import jakarta.persistence.EntityManager;

@Repository
public class OrderDALImpl implements OrderDAL{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Order getOrder(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.get(Order.class, id);
	}

	@Override
	public void saveOrder(Order order) {
		Session session = entityManager.unwrap(Session.class);
		Order newOrder = new Order();
		newOrder.setItems(order.getItems());
		newOrder.setOrderName(order.getOrderName());
		session.persist(order);
	}
	
	

	@Override
	public void deleteOrder(int id) {
		Session session = entityManager.unwrap(Session.class);
		Order order = session.get(Order.class, id);
		session.remove(order);
	}
	
	
}
