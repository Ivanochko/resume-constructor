package com.resume.constructor.security;

import com.resume.constructor.user.auth.dto.UserLoginDto;
import com.resume.constructor.user.auth.dto.UserRegisterDto;

public interface AuthService {

    String login(UserLoginDto user);

    String register(UserRegisterDto user);

    Long getCurrentUserId();

}
