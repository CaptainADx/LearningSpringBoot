package com.geek.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor 
@AllArgsConstructor
public class Address {
	private String placeName;
	private String doorNo;
	private String pinCode;
}
