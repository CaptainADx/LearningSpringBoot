package com.cn.cnkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnkart.entity.Item;
import com.cn.cnkart.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/id/{id}")
	public Item getItemById(@PathVariable long id) {
		
		Item item = itemService.getItemById(id);
		return item;
	}
	
	@PostMapping("/addItem")
	public String addItem(@RequestBody Item item) {
		itemService.addItem(item);
		return "Item Saved Successfully";
	}
}
