package com.lab.springmvc.user.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {
    private String email;
    private String pw;
    private String birthDate;
}
