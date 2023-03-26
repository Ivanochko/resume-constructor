package com.resume.constructor.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class SessionRegistry {

    private final ValueOperations<String, String> redisSessionStorage;

    public SessionRegistry(RedisTemplate<String, String> redisTemplate) {
        redisSessionStorage = redisTemplate.opsForValue();
    }

    public String registerSession(String email) {
        final String sessionId = generateSessionId();
        redisSessionStorage.set(sessionId, email);
        return sessionId;
    }

    public String getEmailBySession(String sessionId) {
        return redisSessionStorage.get(sessionId);
    }

    private String generateSessionId() {
        return new String(
                Base64.getEncoder().encode(
                        UUID.randomUUID().toString().getBytes(StandardCharsets.UTF_8)
                )
        );
    }

}
