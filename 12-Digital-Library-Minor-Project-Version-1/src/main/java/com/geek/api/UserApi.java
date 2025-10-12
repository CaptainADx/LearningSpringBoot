package com.geek.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.geek.dto.BorrowDto;
import com.geek.dto.UserDto;
import com.geek.entity.Book;
import com.geek.entity.User;
import com.geek.service.UserService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/users")
public class UserApi {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public User addNewUser(@RequestBody @Valid UserDto userDto) {
		return userService.addNewUser(userDto);
	}
	
	@PostMapping("/borrowBook")
	public Book borrowBook(@RequestBody @Valid BorrowDto borrowDto) {
		return userService.borrowBook(borrowDto);
	}
	
	@PutMapping("/returnBook")
	public Book returnBook(@RequestParam("transactionId") int tid) {
		return userService.returnBook(tid);
	}
}
