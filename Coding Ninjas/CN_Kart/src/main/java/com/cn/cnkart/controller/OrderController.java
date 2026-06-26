package com.cn.cnkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import com.cn.cnkart.entity.Order;
import com.cn.cnkart.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/id/{id}")
	public Order getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
	
	
	@PostMapping("/save")
	public String saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return "Order saved successfully";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOrder(@PathVariable int id) {
		orderService.deleteOrder(id);
		return "Order has been Deleted with id: " + id;
	}
	
}
