package com.example.fundoo_notes.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {

    private final StringRedisTemplate redisTemplate;

    public JwtUtil(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    private final SecretKey secretKey =
            Keys.hmacShaKeyFor(
                    "ThisIsASecretKeyThatShouldBeAtLeast256BitsLongForHS256"
                            .getBytes());
    private final long expirationMillis =
            1000 * 60 * 60; // 1 hour
    public String generateToken(
            String userId, String email) {
        return Jwts.builder()
                .subject(userId)
                .claim("email", email)
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis()
                                + expirationMillis))
                .signWith(secretKey)
                .compact();
    }
    public String extractUserId(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    public boolean isTokenValid(String token) {

        String cacheKey = "jwt:valid:"+token;

        //check if token is present in redis
        String cached = redisTemplate.opsForValue().get(cacheKey);
        if(cached != null) {
            return Boolean.parseBoolean(cached);
        }

        boolean isValid;
        try {
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            isValid = true;
        } catch (Exception e) {

            isValid= false;
        }

        redisTemplate.opsForValue().set(
                cacheKey,
                String.valueOf(isValid),
                60,
                TimeUnit.SECONDS
        );

        return isValid;
    }
}
