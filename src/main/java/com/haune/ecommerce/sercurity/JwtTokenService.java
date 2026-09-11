package com.haune.ecommerce.sercurity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtTokenService {
    private final RedisTemplate<String, String> redisTemplate;

    private String secretKey;
    private Long accessTokenExpirationMs;
    private Long refreshTokenExpirationMs;

}
