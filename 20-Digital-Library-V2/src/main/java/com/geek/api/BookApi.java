package com.geek.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.BookDto;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookApi {
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addBook")
	public ResponseEntity<Book> addNewBook(@RequestBody @Valid BookDto b){
		Book book = bookService.addBook(b);
		return new ResponseEntity<Book>(book, HttpStatus.CREATED);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> searchByBookId(@PathVariable("bookId") int bookId) {
		Book book = bookService.searchByBookId(bookId);
		return new ResponseEntity<>(book, HttpStatus.FOUND);
		
	}
	
	@GetMapping("/searchByAuthor/{authorId}")
	public ResponseEntity<List<Book>> searchByAuthor(@PathVariable("authorId")  int authorId){
		List<Book> books = bookService.searchByAuthor(authorId);
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping("/searchByGenre/{genre}")
	public ResponseEntity<List<Book>> searchByGenre(@RequestParam("genre") Genre genre){
		List<Book> books = bookService.searchByGenre(genre);
		return new ResponseEntity<>(books, HttpStatus.FOUND);
	}
	
	@GetMapping("/allBooks")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = bookService.allBooks();
		
		return new ResponseEntity<>(books, HttpStatus.OK);
	}


	@GetMapping("/allBooksWithPagination")
	public Page<Book> allBooksWithPagination(@RequestParam("pageNo") int pageNo, @RequestParam("size") int size){
		return bookService.allBookswithPagination(pageNo, size);
	}

}
