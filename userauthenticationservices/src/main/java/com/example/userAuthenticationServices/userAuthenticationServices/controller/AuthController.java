package com.example.userAuthenticationServices.userAuthenticationServices.controller;

import com.example.userAuthenticationServices.userAuthenticationServices.dtos.*;
import com.example.userAuthenticationServices.userAuthenticationServices.exceptions.UserNotFoundException;
import com.example.userAuthenticationServices.userAuthenticationServices.models.User;
import com.example.userAuthenticationServices.userAuthenticationServices.service.IAuthService;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        User user = authService.signup(signupRequestDto.getEmailId(), signupRequestDto.getPassword());
        return from(user);
    }


    private UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmailId(user.getEmailId());
        return userDto;
    }
}

