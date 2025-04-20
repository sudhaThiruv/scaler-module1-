package com.example.authservice.authservice.controller;

import com.example.authservice.authservice.dtos.LoginRequestDto;
import com.example.authservice.authservice.dtos.SignupRequestDto;
import com.example.authservice.authservice.dtos.UserDto;
import com.example.authservice.authservice.dtos.ValidateTokenDto;
import com.example.authservice.authservice.exceptions.UnAuthorizedException;
import com.example.authservice.authservice.exceptions.UserNotFoundException;
import com.example.authservice.authservice.model.User;
import com.example.authservice.authservice.service.IAuthService;
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
        User user = authService.signup(signupRequestDto.getEmailId(),signupRequestDto.getPassword());
        return from(user);
    }
    private UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmailId(user.getEmailId());
        return userDto;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody LoginRequestDto loginRequestDto){
        try {
            Pair<User, String> userwithToken = authService.login(loginRequestDto.getEmailId(), loginRequestDto.getPassword());
            UserDto userDto = from(userwithToken.a);
            MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
            headers.add(HttpHeaders.SET_COOKIE,userwithToken.b);
            return  new ResponseEntity<>(userDto,headers,201);
        }
        catch (UserNotFoundException e){
    return  new ResponseEntity<>(null,null,404);
        }
        catch (PasswordExpiredException e){
return  new ResponseEntity<>(null,null,401);
        }

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
}
