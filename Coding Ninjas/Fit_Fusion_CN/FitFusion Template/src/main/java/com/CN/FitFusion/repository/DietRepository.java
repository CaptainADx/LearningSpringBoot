package com.CN.FitFusion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CN.FitFusion.model.Diet;
import com.CN.FitFusion.model.User;

@Repository
public interface DietRepository extends JpaRepository<Diet, Long>{


	@Query("Select d.user from Diet d where d.id = ?1")
	User getUserByDietId(Long id);

}
