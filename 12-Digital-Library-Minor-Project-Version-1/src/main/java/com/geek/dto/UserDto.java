package com.geek.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
	
	private int userId;
	@NotBlank(message = "First Name cannot be blank")
	private String firstName;
	@NotBlank(message = "Last Name cannot be blank")
	private String lastName;
	@NotBlank(message = "Email cannot be blank")
	private String email;
}
