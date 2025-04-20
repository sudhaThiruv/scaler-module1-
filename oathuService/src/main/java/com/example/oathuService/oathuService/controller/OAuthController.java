package com.example.oathuService.oathuService.controller;

import com.example.oathuService.oathuService.dtos.*;
import com.example.oathuService.oathuService.exceptions.UserNotFoundException;
import com.example.oathuService.oathuService.models.User;
import com.example.oathuService.oathuService.service.IAuthService;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.antlr.v4.runtime.misc.Pair;




@RestController
@RequestMapping("/oauth")
public class OAuthController {


    @Autowired
    private IAuthService authService;

    @PostMapping("/signup")
    public UserDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        User user = authService.signup(signupRequestDto.getEmailId(),signupRequestDto.getPassword());
        return from(user);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            Pair<User, String> userWithToken = authService.login(loginRequestDto.getEmailId(), loginRequestDto.getPassword());
            UserDto userDto =  from(userWithToken.a);
            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add(HttpHeaders.SET_COOKIE,userWithToken.b);
            return new ResponseEntity<>(userDto,headers,201);
        }catch (UserNotFoundException exception) {
            return new ResponseEntity<>(null,null,404);
        }catch (PasswordExpiredException exception) {
            return new ResponseEntity<>(null,null,401);
        }
    }

    @PostMapping("/logout")
    public Boolean logout(@RequestBody LogoutRequestDto logoutRequestDto) {
        //ToDo -: To be implemented by Learners
        return false;
    }


    @PostMapping("/validateToken")
    public ResponseEntity<Boolean> validateToken(@RequestBody ValidateTokenDto validateTokenDto) {
        try {
            Boolean result = authService.validateToken(validateTokenDto.getToken(), validateTokenDto.getUserId());
            return new ResponseEntity<>(result,null,200);
        }catch (Exception exception) {
            return new ResponseEntity<>(false,null,400);
        }
    }

    private UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmailId(user.getEmailId());
        return userDto;
    }
}
