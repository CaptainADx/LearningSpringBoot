package com.CN.FitFusion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CN.FitFusion.dto.UserDto;
import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.User;
import com.CN.FitFusion.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
//	
//	 ADMIN APIs:
//
//      • GET “/user/all”: This API lets the admin fetch all users. It returns an OK response status.
		
		@GetMapping("/all")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('ADMIN')")
		public List<User> getAllUser(){
			return userService.getAllUser(); 
		}
	
	
//
//      • GET “/user/{id}” (@PathVariable Long id): This API allows the admin to fetch a user by its ID. It returns an OK response status.
		
		@GetMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('ADMIN')")
		public UserDto getUser(@PathVariable Long id) {

		    User user = userService.getUserById(id);

		    UserDto dto = new UserDto();
		    dto.setEmail(user.getEmail());
		    dto.setAge(user.getAge());
		    dto.setContactNo(user.getContactNo());
		    dto.setGender(user.getGender());

		    return dto;
		}
		
		
//      • PUT “/user/{id}” (@RequestBody UserDto userDto, @PathVariable Long id): This API allows the admin to update a user by its ID. It returns an OK response status.
		
		@PutMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('ADMIN')")
		public void updateUser(@RequestBody UserDto userDto, @PathVariable Long id){
			userService.updateUser(userDto, id);
		}
		
		
		
//      • DELETE “/user/{id}” (@PathVariable Long id): This API allows the admin to delete a user by its ID. It returns an OK response status.
		
		@DeleteMapping("/{id}")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('ADMIN')")
		public void deleteUser(@PathVariable Long id) {
			userService.deleteUser(id);
		}
		
		
		
		
//
//   CUSTOMER APIs:
//
//      • GET “/user/exercise/{id}" (@PathVariable Long id): This API lets the customer fetch all his/her exercises by the userId. It returns an OK response status.
		@GetMapping("/exercise/{id}")
		@ResponseStatus(HttpStatus.OK)
		@PreAuthorize("hasRole('CUSTOMER')")
		public List<Exercise> getExerciseByUserId(@PathVariable Long id){
			return userService.getExerciseByUserId(id);
		}
		
		
		
//
//      • GET “/user/diet/{id}" (@PathVariable Long id): This API lets the customer fetch all his/her diets by the userId. It returns an OK response status.
		
		@GetMapping("/diet/{id}")
		@ResponseStatus(HttpStatus.OK)

		@PreAuthorize("hasRole('CUSTOMER')")
		public List<Diet> getDietByUserId(@PathVariable Long id){
			return userService.getDietByUserId(id);
		}
		
		
		
//
//   PUBLIC APIs:
//
//      • POST “/user/register” (@RequestBody UserDto userDto): This API allows the user to register and be assigned a role. (Take reference from the Gym Application)
		
		@PostMapping("/register")
		@ResponseStatus(HttpStatus.CREATED)
		public void createUser(@RequestBody UserDto userDto) {
			userService.createUser(userDto);
		}
		
		
		
}
