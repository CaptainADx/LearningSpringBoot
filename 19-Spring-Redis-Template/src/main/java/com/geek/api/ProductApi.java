package com.geek.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.model.Product;
import com.geek.service.ProductService;

@RestController
public class ProductApi {

	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	
	@GetMapping("/searchProduct/{id}")
	public Product searchProduct(@PathVariable("id") int productId) {
		return service.searchProduct(productId);
	}
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
}	
