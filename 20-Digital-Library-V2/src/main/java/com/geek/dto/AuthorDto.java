package com.geek.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorDto {
	
	private int authorId;
	@NotBlank(message="Author Name cannot be blank")
	private String authorName;
}
