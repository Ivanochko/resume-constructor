package com.resume.constructor.user.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDataDto {

    private Long id;
    private String email;
    private String firstName;
    private String lastName;

}
