package com.geek.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer implements Serializable{
	
	@Id
	@GeneratedValue
	int customerId;
	String customerName;
}
