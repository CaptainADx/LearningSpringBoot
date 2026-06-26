package com.cn.cnkart.dal;

import com.cn.cnkart.entity.Order;

public interface OrderDAL {
	public Order getOrder(int id);
	public void saveOrder(Order order);
	public void deleteOrder(int id);
}
