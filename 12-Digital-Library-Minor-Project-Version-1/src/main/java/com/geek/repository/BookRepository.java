package com.geek.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.geek.entity.Book;
import com.geek.entity.Genre;

public interface BookRepository extends JpaRepository<Book, Integer>{
	List<Book> findByBookName(String bookName);
	List<Book> findByGenre(Genre genre);
	
	@Query(value = "Select b from Book b where b.author.authorId= :id")
	List<Book> findByAuthorId(@Param("id") int authorId);
}
