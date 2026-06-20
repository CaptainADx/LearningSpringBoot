package com.cn.cnkart.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cn.cnkart.entity.ItemDetails;

import jakarta.persistence.EntityManager;

@Repository
public class ItemDetailsDALImpl implements ItemDetailsDAL{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		ItemDetails itemDetails = session.get(ItemDetails.class, id);
		
		session.remove(itemDetails);
		
		System.out.println("Item Details deleted Successfully");
	}

}
