package com.CN.Review.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtAuthenticationHelper {
		
	

	private String secret = "thisisacodingninjasdemonstrationforsecretkeyinspringsecurityjsonwebtokenauthentication";
	private static final long JWT_TOKEN_VALIDITY = 60*60;
	
	public String getUsernameFromToken(String token) {
		Claims claims = getClaimsFromToken(token);
		
		return claims.getSubject();
	}

	private Claims getClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(secret.getBytes())
				.build().parseClaimsJws(token).getBody();
	}

	public boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		Claims claims = getClaimsFromToken(token);
		
		return claims.getExpiration().before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		
		Map<String, Object> map = new HashMap<>();
		
		return Jwts.builder()
				.setClaims(map)
				.setSubject(userDetails.getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + (JWT_TOKEN_VALIDITY*1000)) )
				.setIssuedAt(new Date())
				.signWith(new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName()), SignatureAlgorithm.HS256)
				.compact();
	}
}
