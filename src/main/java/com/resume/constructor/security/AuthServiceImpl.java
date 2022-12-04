package com.resume.constructor.security;

import com.resume.constructor.exception.UserByEmailAlreadyExistException;
import com.resume.constructor.mappers.UserMapper;
import com.resume.constructor.user.UserData;
import com.resume.constructor.user.UserRepository;
import com.resume.constructor.user.dto.UserLoginDto;
import com.resume.constructor.user.dto.UserRegisterDto;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final SessionRegistry sessionRegistry;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Override
    public String login(UserLoginDto user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );
        return sessionRegistry.registerSession(user.getEmail());
    }

    @Override
    public String register(UserRegisterDto user) {
        String savedPassword = user.getPassword();
        if (Boolean.TRUE.equals(userRepository.existsByEmail(user.getEmail()))) {
            throw new UserByEmailAlreadyExistException(user.getEmail());
        } else {
            user.setPassword(passwordEncoder.encode(savedPassword));
            UserData userData = userMapper.toData(user);
            userRepository.save(userData);
        }
        user.setPassword(savedPassword);
        return login(userMapper.toLogin(user));
    }

}
