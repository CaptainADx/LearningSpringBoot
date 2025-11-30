package com.geek.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geek.entity.Genre;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class BookDto {
	private int bookId;
	
	@NotBlank(message = "Book Name cannot be blank")
	private String bookName;
	private String title;
	
	@Min(value=0, message="Please Enter a Positive value as Cost")
	private float cost;
	
	@PastOrPresent(message = "Publish Date must be ya Present or Past Date")
	@JsonFormat(pattern = "dd-MMM-yy", locale = "en", shape = JsonFormat.Shape.STRING)
	private LocalDate publishedDate;
	
	@PositiveOrZero(message = "Stock cannot be Negative")
	private int stock;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	private int authorId;
}
