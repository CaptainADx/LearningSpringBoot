package com.geek.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import com.geek.exception.ApplicationException;
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
	
	@Test
	void testSearchBookByIdException() {
		when(bookRepository.findById(2)).thenThrow(new ApplicationException("Book ID is not Found"));
		
		ApplicationException ex = assertThrows(ApplicationException.class, () -> bookService.searchByBookId(2));
		
		assertEquals(ex.getMessage(), "Book ID is not Found");
	}
	
	

	


}
