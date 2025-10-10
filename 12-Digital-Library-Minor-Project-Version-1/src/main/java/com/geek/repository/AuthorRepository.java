package com.geek.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geek.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
}
