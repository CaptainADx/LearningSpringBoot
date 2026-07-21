package com.cn.hotel.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	
	
	@Autowired
	JwtAuthenticationHelper jwtAuthenticationHelper;
	
	@Autowired
	UserDetailsService userDetailsService;
	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestHeader = request.getHeader("Authorization");
		
		String token = null;
		if(requestHeader != null && requestHeader.startsWith("Bearer ")) {
			token = requestHeader.substring(7);
			
			String username = jwtAuthenticationHelper.getUsernameFromToken(token);
			
			UserDetails userDetails = null;
			
			if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				userDetails = userDetailsService.loadUserByUsername(username);
				
				if(jwtAuthenticationHelper.isTokenExpired(token)) {
					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(token, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
						
				}
			}
		}
		
		
		filterChain.doFilter(request, response);
		
		
	}
	
}
