package com.haune.ecommerce.sercurity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtTokenService {
    private final RedisTemplate<String, String> redisTemplate;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Value("${jwt.access-token-expiration-ms}")
    private Long accessTokenExpirationMs;

    @Value("${jwt.refresh-token-expiration-ms}")
    private Long refreshTokenExpirationMs;

    private static final String REDIS_REFRESH_TOKEN_PREFIX = "RT:";
    private static final String REDIS_BLACKLIST_PREFIX = "BL:";

    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateAccessToken(String email, Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + accessTokenExpirationMs);

        return Jwts.builder()
                .subject(email)
                .claim("userId", userId)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();
    }

    public String generateAndSaveRefreshToken(String email, Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + refreshTokenExpirationMs);

        String refreshToken = Jwts.builder()
                .subject(email)
                .claim("userId", userId)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(getSigningKey())
                .compact();

        String redisKey = REDIS_REFRESH_TOKEN_PREFIX + email;
        redisTemplate.opsForValue().set(redisKey, refreshToken, refreshTokenExpirationMs);

        return refreshToken;
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    private Long getExpirationTimeFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getExpiration().getTime();
    }

    public boolean validateToken(String token) {
        try{
            if(isTokenBlacklisted(token)) {
                log.warn("Token đã được thu hồi (Blacklisted)");
                return false;
            }
            Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token);
            return true;
        }catch(Exception ex) {
            log.error("JWT Token không hợp lệ: {}", ex.getMessage());
            return false;
        }
    }

    public void logout(String accessToken, String email) {
        redisTemplate.delete(REDIS_REFRESH_TOKEN_PREFIX + email);

        Long expirationTimeMs = getExpirationTimeFromToken(accessToken);
        Long currentTimeMs = System.currentTimeMillis();
        long ttl = expirationTimeMs - currentTimeMs;

        if(ttl > 0) {
            redisTemplate.opsForValue().set(REDIS_BLACKLIST_PREFIX + accessToken, "logout", ttl, TimeUnit.MILLISECONDS);
        }
    }

    public boolean validateRefreshToken(String email, String refreshToken) {
        String redisKey = REDIS_REFRESH_TOKEN_PREFIX + email;
        String savedToken = redisTemplate.opsForValue().get(redisKey);
        return savedToken != null && savedToken.equals(refreshToken) && validateToken(refreshToken);
    }

    private boolean isTokenBlacklisted(String token) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(REDIS_BLACKLIST_PREFIX + token));
    }
}
