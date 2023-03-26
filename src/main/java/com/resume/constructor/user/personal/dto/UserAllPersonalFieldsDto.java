package com.resume.constructor.user.personal.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class UserAllPersonalFieldsDto {

    private String email;
    private String firstName;
    private String lastName;
    private String title;
    private String location;
    private String phoneNumber;
    private String summary;
    private Sex sex;
    private List<Contact> contacts;

}
