package com.cn.hotel.jwt;

import java.util.*;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtAuthenticationHelper {
	
	
	private String secret = "mySecretKey";
	
	public SecretKey buildSecretKey(String secret) {
		SecretKey key  = Keys.hmacShaKeyFor(secret.getBytes());
		return key;
	}
	
	public String getUsernameFromToken(String token) {
		Claims claims = getClaimsFromToken(token);
		String username = claims.getSubject();
		
		return username;
	}
	
	public Claims getClaimsFromToken(String token) {
		
		SecretKey key = buildSecretKey(secret);
		
		Claims claims =  Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(token)
				.getPayload();
				
		return claims;
	}
	
	public Boolean isTokenExpired(String token) {
		Date date = getClaimsFromToken(token).getExpiration();
		
		return date.before(new Date());
	}
	
	
	
	
}
