package com.spring.example.app.JWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String secret = "JwAeCxGeJ/6i1WNvZ0u9+X/4tog3D/a+/1vh+KDf3Yc=";

	public String extractUsername(String token) {
		return extractClaims(token, t -> t.getSubject());
	}

	public Date extractExpiration(String token) {
		return extractClaims(token, t -> t.getExpiration());
	}

	public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		System.out.println("claims.getExpiration(): " + claims.getExpiration());
		return claimsResolver.apply(claims);
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getBytesFromBase64(secret)).build().parseClaimsJws(token).getBody();
	}

	public Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(String username, String role) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("role", role);
		return createToken(claims, username);
	}

	private String createToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2))
				.signWith(SignatureAlgorithm.HS256, secret).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		// TODO
		final String username = extractUsername(token);
		System.out.println("username: " + username);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private byte[] getBytesFromBase64(String base64) {
		return java.util.Base64.getDecoder().decode(base64);
	}
}
