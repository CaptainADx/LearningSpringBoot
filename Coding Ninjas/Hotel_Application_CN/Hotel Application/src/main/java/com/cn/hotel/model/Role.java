package com.cn.hotel.model;

import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="role")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	Long id;
	
	@Column
	String roleName;
	
	@ManyToMany(mappedBy = "roles")
	Set<User> users;
}
