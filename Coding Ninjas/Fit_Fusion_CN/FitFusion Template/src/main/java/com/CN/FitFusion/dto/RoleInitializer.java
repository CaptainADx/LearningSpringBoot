package com.CN.FitFusion.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;

import javax.annotation.PostConstruct;
import com.CN.FitFusion.model.Role;
import com.CN.FitFusion.repository.RoleRepository;

@Component
public class RoleInitializer {
	@Autowired
	private RoleRepository roleRepo;

	@PostConstruct
	public void addDefaultRoles() {
		if (!roleRepo.findByRoleName("ROLE_ADMIN").isPresent())
			roleRepo.save(new Role(null, "ROLE_ADMIN", new HashSet<>()));
		if (!roleRepo.findByRoleName("ROLE_TRAINER").isPresent())
			roleRepo.save(new Role(null, "ROLE_TRAINER", new HashSet<>()));
		if (!roleRepo.findByRoleName("ROLE_CUSTOMER").isPresent())
			roleRepo.save(new Role(null, "ROLE_CUSTOMER", new HashSet<>()));
	}
}