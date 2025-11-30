package com.geek.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity(name = "Transaction")
@Data
public class Transaction {
	@Id 
	@GeneratedValue
	private int transactionId;
	
	private LocalDate borrowedDate;
	private LocalDate returnedDate;
	
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	
	private float amount;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	@ManyToOne
	@JoinColumn(name="penalty_id")
	private Penalty penalty;
	
}
