package com.geek.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.AuthorDto;
import com.geek.entity.Author;
import com.geek.service.BookService;

import jakarta.validation.Valid;


@RestController
public class AuthorApi {
	@Autowired
	private BookService bookService;
	
	@PostMapping("/addAuthor")
	public ResponseEntity<Author> addNewAuthor(@RequestBody @Valid AuthorDto a){
		Author author = bookService.addAuthor(a);
		return new ResponseEntity<Author>(author, HttpStatus.CREATED);
	}
	
}
	
