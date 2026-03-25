package com.example.auth.api.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    
    String privateKey = "keyWzA21AHKb8NcC7STopUjHeA9SmkoKvi6Q2GIcYxS1Sc";
    
    public String generateToken(String username) {
        
        Map<String, Object>  claims = new HashMap<>(); 

        return Jwts.builder()
            .claims()
            .add(claims)
            .subject(username)
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
            .and()
            .signWith(getKey())
            .compact();
    }

    public SecretKey getKey() {

        byte[] keyByte = Decoders.BASE64.decode(privateKey);
        return Keys.hmacShaKeyFor(keyByte);
    }

    public String extractUsername(String token) {

        return extractClaims(token, Claims::getSubject);
    }
}
