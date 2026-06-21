package com.cn.cnkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.dal.ItemReviewDAL;
import com.cn.cnkart.entity.ItemReview;

import jakarta.transaction.Transactional;

@Service
public class ItemReviewService {

	@Autowired
	ItemReviewDAL itemReviewDAL;

	@Transactional
	public void save(ItemReview itemReview) {
		itemReviewDAL.save(itemReview);
		System.out.println("Item Review Saved Successfully.");	
	}
}
