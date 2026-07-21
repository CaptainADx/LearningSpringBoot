package com.CN.FitFusion.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtAuthenticationHelper {
	
	private static final String SECRET = "mySuperSecretKeyForJwtAuthentication123456789";
	
	
	private static final long TOKEN_EXP = 60 * 60 * 1000L;
	
	public String getUsernameFromToken(String token) {
		return getClaimsFromToken(token).getSubject();
		
	}

	private Claims getClaimsFromToken(String token) {
		
		
		return Jwts.parser()
				   .setSigningKey(SECRET)
				   .parseClaimsJws(token)
				   .getBody();
		
		
	}
	
	public boolean isTokenExpired(String token) {
        return getClaimsFromToken(token)
                .getExpiration()
                .before(new Date());
    }
	
	public boolean validateToken(String token, UserDetails userDetails) {

        String username = getUsernameFromToken(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }
	
	
	public String buildToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		
		
		return Jwts.builder()
				   .setClaims(claims)
				   .setSubject(userDetails.getUsername())
				   .setIssuedAt(new Date())
				   .setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXP))
				   .signWith(SignatureAlgorithm.HS256, SECRET)
				   .compact();
		
		
	}
	
	
	
	
	
	
	
	

	
}
