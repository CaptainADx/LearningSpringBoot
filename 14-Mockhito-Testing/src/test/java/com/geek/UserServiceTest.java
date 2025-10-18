package com.geek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	private UserRepository userRepo;
	
	@InjectMocks
	private UserService userService;
	
	@Test
	void testUserService() {
		User mockUser = new User(101, "Abhijeet", true);
		
		assertEquals(101, mockUser.getId());
	    assertEquals("Abhijeet", mockUser.getName());
	    assertEquals(true, mockUser.isPremium());
	}

	@Test
	void testGetUserNameInUpperCase() {
		User mockUser = new User(101, "Abhijeet", true);
		when(userRepo.findById(101)).thenReturn(mockUser);
		
		String name = userService.getUserNameInUpperCase(101);
		
		assertEquals("ABHIJEET", name);
		verify(userRepo, times(1)).findById(101);
	}

	@Test
	void testGetAllPremiumUser() {
		List<User> mockUsers = Arrays.asList(
					new User(101, "Abhijeet", true),
					new User(102, "Archana", true),
					new User(103, "Shruti", false),
					new User(104, "Usman", false),
					new User(105, "Stuti", true)
				);
		
		when(userRepo.getAllUser()).thenReturn(mockUsers);
		List<String> names = userService.getAllPremiumUser();
		
		assertEquals(3, names.size());
		
		assertEquals(true, names.contains("Abhijeet"));
		assertEquals(true, names.contains("Archana"));
		assertEquals(true, names.contains("Stuti"));
		assertEquals(false, names.contains("Usman"));
		assertEquals(false, names.contains("Shruti"));
		
		verify(userRepo, times(1)).getAllUser();
	}

	@Test
	void testCheckForPremium() {
		User mockUser = new User(101, "Abhijeet", true);
		User mockUser2 = new User(102, "Shruti", false);
		
		
		when(userRepo.findById(101)).thenReturn(mockUser);
		when(userRepo.findById(102)).thenReturn(mockUser2);
		assertEquals(true, userService.checkForPremium(101));
		assertFalse(userService.checkForPremium(102));
		
		verify(userRepo, times(1)).findById(101);
		verify(userRepo, times(1)).findById(102);
		
		
	}

}












