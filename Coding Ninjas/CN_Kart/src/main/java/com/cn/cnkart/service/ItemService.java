package com.cn.cnkart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.dal.ItemDAL;
import com.cn.cnkart.entity.Item;

import jakarta.transaction.Transactional;

@Service
public class ItemService {
	
	@Autowired
	ItemDAL itemDal;
	
	
	@Transactional
	public Item getItemById(long id) {
		return itemDal.getById(id);
	}
	
	@Transactional
	public void addItem(Item item) {
		itemDal.addItem(item);
	}
	
	@Transactional
	public void deleteById(long id) {
		itemDal.deleteById(id);
		
	}

	@Transactional
	public void updateItem(Item item) {
		itemDal.updateItem(item);
		
	}
}
