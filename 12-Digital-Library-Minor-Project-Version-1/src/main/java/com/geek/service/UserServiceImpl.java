package com.geek.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.geek.entity.Book;
import com.geek.entity.Transaction;
import com.geek.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public User addNewUser(User u) {
		return null;
	}

	@Override
	public Book borrowBook() {
		return null;
	}

	@Override
	public Book returnBook(int tid) {
		return null;
	}

	@Override
	public boolean checkAvailability(int id) {
		return false;
	}

	@Override
	public List<Transaction> checkTransactionByUser(int userId) {
		return null;
	}

}
