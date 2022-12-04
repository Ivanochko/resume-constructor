package com.resume.constructor.security;

import com.resume.constructor.user.dto.UserLoginDto;
import com.resume.constructor.user.dto.UserRegisterDto;

public interface AuthService {

    String login(UserLoginDto user);

    String register(UserRegisterDto user);

}
