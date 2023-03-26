package com.resume.constructor.security;

import java.util.Optional;

import com.resume.constructor.exception.UserByEmailAlreadyExistException;
import com.resume.constructor.mappers.UserMapper;
import com.resume.constructor.user.auth.LoginUserDetails;
import com.resume.constructor.user.auth.UserAuthEntity;
import com.resume.constructor.user.auth.UserAuthRepository;
import com.resume.constructor.user.auth.dto.UserLoginDto;
import com.resume.constructor.user.auth.dto.UserRegisterDto;
import com.resume.constructor.user.personal.UserPersonalEntity;
import com.resume.constructor.user.personal.UserPersonalRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final SessionRegistry sessionRegistry;
    private final UserAuthRepository userAuthRepository;
    private final UserPersonalRepository userPersonalRepository;
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
        if (Boolean.TRUE.equals(userAuthRepository.existsByEmail(user.getEmail()))) {
            throw new UserByEmailAlreadyExistException(user.getEmail());
        } else {
            user.setPassword(passwordEncoder.encode(savedPassword));
            saveNewUser(user);
        }
        user.setPassword(savedPassword);
        return login(userMapper.toLogin(user));
    }

    @Override
    public Long getCurrentUserId() {
        LoginUserDetails loginUserDetails =
                (LoginUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<UserAuthEntity> byEmail = userAuthRepository.getByEmail(loginUserDetails.getUsername());
        if (byEmail.isEmpty()) {
            throw new UsernameNotFoundException("User with email " + loginUserDetails.getUsername() + " not found!");
        }
        return byEmail.get().getId();
    }

    private void saveNewUser(UserRegisterDto userRegisterDto) {
        UserAuthEntity userAuth = userAuthRepository.save(userMapper.toData(userRegisterDto));
        UserPersonalEntity userPersonal = userMapper.toPersonalData(userRegisterDto, userAuth.getId());
        userPersonalRepository.save(userPersonal);
    }
}
