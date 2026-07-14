package com.cn.hotel.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class HotelSecurityConfig {
	@Autowired
	UserDetailsService userDetailsService;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(request -> request
					.requestMatchers("user/register")
					.permitAll()
			)
			.rememberMe(remember -> remember.userDetailsService(userDetailsService))
			.formLogin(form -> form
					.loginPage("/login")
					.permitAll()
			)
			.logout(logout -> logout
					.deleteCookies("JSESSIONID")
					.permitAll());
		
		return http.build();
	}
    
//    @Bean
//    UserDetailsService userDetailsService() {
//    	UserDetails user1 = User.builder()
//    							.username("tony")
//    							.password(passwordEncoder().encode("password"))
//    							.roles("ADMIN")
//    							.build();
//    	
//    	UserDetails user2 = User.builder()
//    							.username("steve")
//    							.password(passwordEncoder().encode("nopassword"))
//    							.roles("NORMAL")
//    							.build();
//    	
//    	return new InMemoryUserDetailsManager(user1, user2);
//    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
    	return builder.getAuthenticationManager();
    }
    
    
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
