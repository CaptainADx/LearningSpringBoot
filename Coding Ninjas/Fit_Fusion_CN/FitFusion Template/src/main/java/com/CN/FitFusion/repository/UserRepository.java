package com.CN.FitFusion.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.Exercise;
import com.CN.FitFusion.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("Select e from Exercise e where e.user.id = ?1")
	List<Exercise> findExerciseByUserId(Long id);

	
	@Query("Select d from Diet d where d.user.id = ?1")
	List<Diet> findDietByUserId(Long id);

	
	Optional<User> findByEmail(String username);

}
