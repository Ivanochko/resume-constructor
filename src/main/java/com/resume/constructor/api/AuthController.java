package com.resume.constructor.api;

import java.util.Map;

import com.resume.constructor.security.AuthService;
import com.resume.constructor.user.auth.dto.UserLoginDto;
import com.resume.constructor.user.auth.dto.UserRegisterDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserLoginDto user) {
        String sessionId = authService.login(user);
        return ResponseEntity.ok(Map.of("sessionId", sessionId));
    }

    @PostMapping("register")
    public ResponseEntity<Map<String, String>> register(@RequestBody UserRegisterDto user) {
        String sessionId = authService.register(user);
        return ResponseEntity.ok(Map.of("sessionId", sessionId));
    }

}
