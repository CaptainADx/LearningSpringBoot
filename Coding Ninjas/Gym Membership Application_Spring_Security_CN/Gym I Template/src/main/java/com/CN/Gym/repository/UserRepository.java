package com.CN.Gym.repository;

import com.CN.Gym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	public Optional<User> findByEmail(String email);

//	public UserDetails findByUserName(String username);
}
