package com.geek.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.geek.dto.AuthorDto;
import com.geek.dto.BookDto;
import com.geek.entity.Author;
import com.geek.entity.Book;
import com.geek.entity.Genre;
import com.geek.exception.ApplicationException;
import com.geek.repository.AuthorRepository;
import com.geek.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private AuthorRepository authRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	@Override
	public Author addAuthor(AuthorDto authorDto) {
		Author author = new Author();
		
		//Now copy all properties of DTO to entity
		BeanUtils.copyProperties(authorDto, author); //This will copy AuthorDto properties to Author object
		
		//Now save this author to author table in database
		return authRepo.save(author);
	}

	@Override
	public Book searchByBookId(int bookId) {
		Book book = bookRepo.findById(bookId).orElseThrow(() -> new ApplicationException("Book ID is not Found"));
		return book;
	}

	@Override
	public Book addBook(BookDto bookDto) {
		int authorId = bookDto.getAuthorId();
		
		Optional<Author> optionalAuthor =   authRepo.findById(authorId);
		Optional<Book> optionalBook = bookRepo.findById(bookDto.getBookId());
		
		if(optionalBook.isPresent()) {
			throw new ApplicationException("This book is already Present");
		}
		
		
		Author author = optionalAuthor.get();
		
		
		if(optionalAuthor.isPresent()) {
			Book book = new Book();
			
			BeanUtils.copyProperties(bookDto, book);
			book.setAuthor(author);
			return bookRepo.save(book);
		}
		
		return null;
	}

	@Override
	public List<Book> searchByGenre2(Genre genre) {
		return null;
	}

	@Override
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	@Override
	public Page<Book> allBookswithPagination(int pageNo, int size) {
//		Pageable pageable = PageRequest.of(pageNo, size);
		
		//
		Pageable pageable = PageRequest.of(pageNo, size, Sort.by("bookName"));
		
		return bookRepo.findAll(pageable);
	}

	@Override
	public List<Book> searchByAuthor(int authorId) {
		return null;
	}

	@Override
	public List<Book> searchByGenre(Genre genre) {
		return bookRepo.findByGenre(genre);
	}

	@Override
	public void removeBook(int bookId) {
		
	}

	@Override
	public List<Book> searchByBookName(String bookName) {
		return bookRepo.findByBookName(bookName);
		
	}

	@Override
	public int updateCost(int bookId, float cost) {
		return 0;
	}

}
