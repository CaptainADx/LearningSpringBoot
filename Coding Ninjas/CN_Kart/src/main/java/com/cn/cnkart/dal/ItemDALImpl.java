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
	

	@Override
	public Item getById(long id) {
		Session session = entityManager.unwrap(Session.class);
		Item item = session.get(Item.class, id);
		return item;
		
	}

	@Override
	public void addItem(Item item) {
		Session session = entityManager.unwrap(Session.class);

		session.persist(item);
		
	}

	@Override
	public void deleteById(long id) {
		Session session = entityManager.unwrap(Session.class);
		Item item = session.get(Item.class, id);
		
		session.remove(item);
		
	}

	@Override
	public void updateItem(Item item) {
		//Fetching the current Item
		Item updatedItem = getById(item.getId());
		
		updatedItem.setName(item.getName());
		updatedItem.setDescription(item.getDescription());
		
		//This line Below, is not explicitly needed as Session already fetches and manages the Updated Item Object.
		//session.merge(updatedItem);    
	}

}
