package com.example.authservice.authservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequestDto {
    private String emailId;
    private String password;
}