package com.geek.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.geek.dto.AuthorDto;
import com.geek.dto.BookDto;
import com.geek.entity.Author;
import com.geek.entity.Book;
import com.geek.entity.Genre;

public interface BookService {
	Author addAuthor(AuthorDto authorDto);
	Book searchByBookId(int bookId);
	Book addBook(BookDto bookDto);		//Parameter Book is not Passed in the Trainer's Code
	List<Book> searchByGenre2(Genre genre);
	List<Book> allBooks();
	Page<Book> allBookswithPagination(int pageNo, int size);
	List<Book> searchByAuthor(int authorId);
	List<Book> searchByGenre(Genre genre);
	void removeBook(int bookId);
	
	List<Book> searchByBookName(String bookName);
	public int updateCost(int bookId, float cost);
	
}	
