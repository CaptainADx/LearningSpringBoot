package com.geek.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.geek.model.Product;

@Service
public class ProductService {
	
	static final String KEY = "product";
	
	@Autowired
	private RedisTemplate<String, Product> template;
	
	public Product addProduct(Product p) {
		//Will store the product to redis cache
		//Key will be the ProductId & Value will be the ProductName
		
		template.opsForHash().put(KEY, p.getProductId(), p);
		template.expire(KEY, java.time.Duration.ofMinutes(30));
		
		return p;
	}
	
	public Product searchProduct(int productId) {
		Product p = (Product) template.opsForHash().get(KEY, productId);
		template.expire(KEY, java.time.Duration.ofMinutes(30));
		return p;
	}
	
	
	public List<Product> getAllProducts(){
		Map<Object, Object> entries = template.opsForHash().entries(KEY);
		return entries.values().stream().map(obj -> (Product)obj).collect(Collectors.toList());
	}
	
	
}
