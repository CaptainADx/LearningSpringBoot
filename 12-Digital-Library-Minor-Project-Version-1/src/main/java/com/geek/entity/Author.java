package com.geek.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name="Author")
@Data
public class Author {
	@Id
	
	private int authorId;
	@NotBlank(message = "Author Name cannot be blank")
	private String authorName;
} 
