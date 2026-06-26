package com.cn.cnkart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.cnkart.dal.ItemDAL;
import com.cn.cnkart.dal.OrderDAL;
import com.cn.cnkart.entity.Item;
import com.cn.cnkart.entity.Order;

import jakarta.transaction.Transactional;


@Service
public class OrderService {
	
	@Autowired
	OrderDAL orderDAL;
	
	@Autowired
	ItemDAL itemDal;
	
	@Transactional
	public Order getOrderById(int id) {
		return orderDAL.getOrder(id);
	}
	
	@Transactional
	public void saveOrder(Order order) {
		Order newOrder = new Order();
		
		List<Item> itemList = new ArrayList<Item>();
		
		for(Item item : order.getItems()) {
			Item currItem = itemDal.getById(item.getId());
			itemList.add(currItem);
		}
		
		newOrder.setItems(itemList);
		newOrder.setOrderName(order.getOrderName());
		orderDAL.saveOrder(newOrder);
	}
	
	
	@Transactional
	public void deleteOrder(int id) {
		orderDAL.deleteOrder(id);
	}
	
}
