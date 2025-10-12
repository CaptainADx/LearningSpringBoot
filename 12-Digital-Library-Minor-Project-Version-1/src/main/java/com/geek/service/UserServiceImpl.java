package com.geek.service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.geek.dto.BorrowDto;
import com.geek.dto.UserDto;
import com.geek.entity.Book;
import com.geek.entity.Penalty;
import com.geek.entity.Transaction;
import com.geek.entity.TransactionType;
import com.geek.entity.User;
import com.geek.exception.ApplicationException;
import com.geek.repository.BookRepository;
import com.geek.repository.PenaltyRepository;
import com.geek.repository.TransactionRepository;
import com.geek.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private TransactionRepository transactRepo;
	@Autowired
	private PenaltyRepository penaltyRepo;
	
	@Override
	public User addNewUser(@RequestBody UserDto userDto) {
		User user = new User();
		
		//Copy all properties of Dto to entity
		BeanUtils.copyProperties(userDto, user);
		
		//Now save this User to UserTable in database
		return userRepo.save(user);
		
	}


	@Override
	public Book returnBook(int tid) {
		Transaction t = transactRepo.findById(tid).orElseThrow(()-> new ApplicationException("Transaction Not Found"));
		Book b = bookRepo.findById(t.getBook().getBookId()).get();
		if(t.getTransactionType() == TransactionType.BORROW) {
			
			LocalDate currentDate = LocalDate.now();
			LocalDate borrowedDate = t.getBorrowedDate();
			
			long daysDifference = Duration.between(borrowedDate.atStartOfDay(), currentDate.atStartOfDay()).toDays();
			
			if((daysDifference - 30) < 0) {
				
				Penalty penalty = new Penalty();
				penalty.setNoOfDaysDiff((int)daysDifference);
				float amount = daysDifference * 10;
				
				penalty.setAmount(amount);
				penalty.setDescription("Return delayed by : " + daysDifference + "Days" + "\n" + 
										"Penalty Charges is : " + amount + "/- only"
										);
				
				penaltyRepo.save(penalty);
				
				t.setReturnedDate(currentDate);
				t.setTransactionType(TransactionType.RETURN);
				t.setAmount(b.getCost());
				
				transactRepo.save(t);
				

				b.setStock(b.getStock()+1);
				bookRepo.save(b);
				
				
			} else {
				t.setReturnedDate(currentDate);
				t.setTransactionType(TransactionType.RETURN);
				t.setAmount(b.getCost());
				transactRepo.save(t);
				
				b.setStock(b.getStock()+1);
				bookRepo.save(b);
			}
		} else {
			throw new ApplicationException("Book is Already Returned");
		}
		return b;
	}

	@Override
	public boolean checkAvailability(int id) {
		return false;
	}

	@Override
	public List<Transaction> checkTransactionByUser(int userId) {
		return null;
	}

	@Override
	public Book borrowBook(BorrowDto borrowDto) {
		// Fetch user (throws exception if not found)
		User user = userRepo.findById(borrowDto.getUserId()).orElseThrow(() -> new ApplicationException("User Not found"));

		// Fetch book (throws exception if not found)
		Book book = bookRepo.findById(borrowDto.getBookId()).orElseThrow(() -> new ApplicationException("Book Not found"));
		
		   if(book.getStock() > 0) {
			   Transaction transaction = new Transaction();
			   transaction.setBorrowedDate(LocalDate.now());
			   transaction.setUser(user);
			   transaction.setBook(book);
			   transaction.setTransactionType(TransactionType.BORROW);
			   transaction.setAmount(book.getCost());
			   book.setStock(book.getStock()-1);
			   bookRepo.save(book);
			   
			   transactRepo.save(transaction);
			   
			   
		   } else {
			   throw new ApplicationException("Sorry! No stock for : "+ book.getBookName());
		   }
		   
		   return book;
		   
	}

}
