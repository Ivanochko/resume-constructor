package com.resume.constructor.user.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
