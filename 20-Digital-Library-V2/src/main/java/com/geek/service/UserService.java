package com.geek.service;

import java.util.List;

import com.geek.dto.BorrowDto;
import com.geek.dto.UserDto;
import com.geek.entity.Book;
import com.geek.entity.Transaction;
import com.geek.entity.User;

public interface UserService {
	User addNewUser(UserDto userDto);
	Book borrowBook(BorrowDto borrowDto);
	Book returnBook(int tid);
	boolean checkAvailability(int id);
	List<Transaction> checkTransactionByUser(int userId);

}
