package com.geek.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import com.geek.entity.Author;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.repository.BookRepository;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {
	@Mock
	private BookRepository bookRepository;
	
	@InjectMocks
	private BookServiceImpl bookService;
	
	
	
	@Test
	void testSearchBookById() {
		Book mockBook = new Book(1, "ABC", "XYZ", 100.0f, LocalDate.of(2025, 1,1), 10, Genre.FANTASY, new Author());
		
		//Precondition
		when(bookRepository.findById(1)).thenReturn(Optional.of(mockBook));
		
		Book b = bookService.searchByBookId(1);
		
		assertEquals(b.getBookName(), mockBook.getBookName());
		
		verify(bookRepository, times(1)).findById(1);
		
		
		
		
	}



	private Object verify(BookRepository bookRepository2, VerificationMode times) {
		// TODO Auto-generated method stub
		return null;
	}

}
