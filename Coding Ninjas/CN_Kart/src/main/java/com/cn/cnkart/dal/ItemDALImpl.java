package com.cn.cnkart.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnkart.entity.Item;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;


@Repository
public class ItemDALImpl implements ItemDAL {
	
	@Autowired
	EntityManager entityManager;
	
	Session session;
	
	@PostConstruct
	public void init() {
		session = entityManager.unwrap(Session.class);
	}
	
	@Override
	public Item getById(long id) {
		
		Item item = session.get(Item.class, id);
		return item;
		
	}

	@Override
	public void addItem(Item item) {
		
		session.persist(item);
		
	}

}
