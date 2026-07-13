package com.CodingNinjas.LeaveXpress.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class LeaveSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(requests -> requests
					.anyRequest()
					.authenticated()
			)
			.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	UserDetailsService users() {
		UserDetails user1 = User.builder()
								.username("tony")
								.password(passwordEncoder().encode("password"))
								.roles("MANAGER")
								.build();
		
		UserDetails user2 = User.builder()
								.username("steve")
								.password(passwordEncoder().encode("nopassword"))
								.roles("EMPLOYEE")
								.build();
		
		return new InMemoryUserDetailsManager(user1, user2);
	}

	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
