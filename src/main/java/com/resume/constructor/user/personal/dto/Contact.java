package com.resume.constructor.user.personal.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Contact implements Serializable {
    private static final long serialVersionUID = 7702L;

    private String label;
    private String value;

}
