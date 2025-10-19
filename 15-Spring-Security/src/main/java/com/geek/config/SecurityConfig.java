package com.geek.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
	UserDetailsService userDetailService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(User.withUsername("Abhijeet")
				.password(passwordEncoder().encode("adx123"))
				.roles("ADMIN")
				.build()
				);
		
		manager.createUser(User.withUsername("Vishu")
				.password(passwordEncoder().encode("geek"))
				.roles("USER")
				.build()
				);
		
		return manager;
	}
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests( auth -> auth
					.requestMatchers("/home/admin/**").hasRole("ADMIN")
					.requestMatchers("/home/user/**").hasAnyRole("ADMIN", "USER")
					.requestMatchers("/home").permitAll()
			)
			.formLogin( form -> form
						.defaultSuccessUrl("/home", true)
					);
		
		return http.build();
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//For the CORS configuration
	//We need to define a separate bean after Spring Security 6.1+
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.addAllowedOrigin("*"); // allow all origins
	    configuration.addAllowedMethod("*"); // allow all methods (GET, POST, etc.)
	    configuration.addAllowedHeader("*"); // allow all headers

	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}
	
	
}
