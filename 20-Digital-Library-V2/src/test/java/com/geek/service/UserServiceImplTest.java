package com.geek.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.geek.entity.Author;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.entity.Penalty;
import com.geek.entity.Transaction;
import com.geek.entity.TransactionType;
import com.geek.repository.BookRepository;
import com.geek.repository.PenaltyRepository;
import com.geek.repository.TransactionRepository;
import com.geek.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
	
	@Mock
	private BookRepository bookRepo;
	
	@Mock
	private UserRepository userRepo;
	
	@Mock
	private TransactionRepository transactRepo;
	
	@Mock
	private PenaltyRepository penaltyRepo;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Test
	public void testReturnBookWithoutPenalty() {
		
		Book mockBook = new Book();
		mockBook.setBookId(1);
		mockBook.setBookName("System Designing");
		mockBook.setTitle("Technology");
		mockBook.setCost(100);
		mockBook.setPublishedDate(LocalDate.of(2025,6,1));
		mockBook.setStock(20);
		mockBook.setGenre(Genre.COMPUTERS);
		mockBook.setAuthor(new Author());
		
		
		
		Transaction mockTransaction = new Transaction();
		mockTransaction.setTransactionId(991);
		mockTransaction.setTransactionType(TransactionType.BORROW);
		mockTransaction.setAmount(100);
		mockTransaction.setBorrowedDate(LocalDate.of(2025,11,5));
		mockTransaction.setReturnedDate(LocalDate.of(2025, 11, 30));
		mockTransaction.setBook(mockBook);
		
		when(transactRepo.findById(991)).thenReturn(Optional.of(mockTransaction));
		when(bookRepo.findById(1)).thenReturn(Optional.of(mockBook));
		
		userService.returnBook(991);
		
		assertEquals(TransactionType.RETURN, mockTransaction.getTransactionType());
		
		verify(transactRepo, times(1)).findById(991);
		verify(bookRepo, times(1)).findById(1);
			
	}
	
	@Test
	public void testReturnBookWithPenalty() {
		
		//<-----------WORKING ON THIS SECTION--------------->
		//<-----------WORKING ON THIS SECTION--------------->
		//<-----------WORKING ON THIS SECTION--------------->
		//<-----------WORKING ON THIS SECTION--------------->
		
		Book mockBook = new Book();
		mockBook.setBookId(1);
		mockBook.setBookName("System Designing");
		mockBook.setTitle("Technology");
		mockBook.setCost(100);
		mockBook.setPublishedDate(LocalDate.of(2025,6,1));
		mockBook.setStock(20);
		mockBook.setGenre(Genre.COMPUTERS);
		mockBook.setAuthor(new Author());
		
		
		
		Transaction mockTransaction = new Transaction();
		mockTransaction.setTransactionId(991);
		mockTransaction.setTransactionType(TransactionType.BORROW);
		mockTransaction.setBorrowedDate(LocalDate.of(2025,10,5));
		mockTransaction.setReturnedDate(LocalDate.of(2025, 11, 30));
		mockTransaction.setBook(mockBook);
		
		when(transactRepo.findById(991)).thenReturn(Optional.of(mockTransaction));
		when(bookRepo.findById(1)).thenReturn(Optional.of(mockBook));
		
		userService.returnBook(991);
		
		assertEquals(TransactionType.RETURN, mockTransaction.getTransactionType());
		
		verify(transactRepo, times(1)).findById(991);
		verify(bookRepo, times(1)).findById(1);
		
		Penalty p = mockTransaction.getPenalty();
//		System.out.println(p.getDescription());
		assertEquals("Return delayed by : " + 64 + "Days" + "\n" + 
										"Penalty Charges is : " + 640.0 + "/- only", p.getDescription());
		
			
	}   
	
	
}









