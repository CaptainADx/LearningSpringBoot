package com.cn.cnkart.dal;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.entity.ItemReview;

import jakarta.persistence.EntityManager;

@Service
public class ItemReviewDALImpl implements ItemReviewDAL{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void save(ItemReview itemReview) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(itemReview);
		
	}

}
