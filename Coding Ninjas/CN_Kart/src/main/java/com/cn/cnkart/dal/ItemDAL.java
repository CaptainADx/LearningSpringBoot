package com.cn.cnkart.dal;

import com.cn.cnkart.entity.Item;

public interface ItemDAL {
	Item getById(long id);
	void addItem(Item item);
	void deleteById(long id);
	void updateItem(Item item);
}
