package com.cn.cnkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.dal.ItemDetailsDAL;

import jakarta.transaction.Transactional;

@Service
public class ItemDetailsService {
	
	@Autowired
	ItemDetailsDAL itemDetailsDAL;

	
	@Transactional
	public void deleteItemDetailsById(int id) {
		itemDetailsDAL.deleteById(id);
		
	}

}
