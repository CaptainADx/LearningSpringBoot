package com.geek.model;


import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import lombok.Data;


@Data
public class Product implements Serializable{
	
	@GeneratedValue
	
	private int productId;
	
	private String productName;
}
