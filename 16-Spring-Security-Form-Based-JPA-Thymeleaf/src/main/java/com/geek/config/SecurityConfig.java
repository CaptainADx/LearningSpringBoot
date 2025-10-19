package com.geek.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private MyUserDetailService userDetailService;
	
	AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception{
		
		return http.getSharedObject(AuthenticationManagerBuilder.class)
		.userDetailsService(userDetailService)
		.passwordEncoder(passwordEncoder)
		.and()
		.build();
		
		
	}
	
	
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.
			csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/login", "/register", "/css/**", "/js/**")
					.permitAll()
					.anyRequest()
					.authenticated()
					)
			.formLogin(form -> form
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/home")
					.failureUrl("/login?error=true")
	                .permitAll()
					)
			.logout(logout -> logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout=true")
					);
		
		return http.build();
	}
	
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
