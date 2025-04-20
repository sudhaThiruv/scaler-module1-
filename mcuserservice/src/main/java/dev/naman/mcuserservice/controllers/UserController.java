package dev.naman.mcuserservice.controllers;

import dev.naman.mcuserservice.dto.SignUpUserRequestDto;
import dev.naman.mcuserservice.dto.VerifyUserRequestDto;
import dev.naman.mcuserservice.service.UserService;
import org.springframework.web.bind.annotation.*;
import dev.naman.mcuserservice.Models.User;



@RestController
@RequestMapping
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

@PostMapping("/users")
public  User signUp(@RequestBody SignUpUserRequestDto request){
    return  userService.signUp(request.getEmail(),request.getPassword());
}
@PostMapping("users/verify")
public  boolean verifyUser(@RequestBody VerifyUserRequestDto requestDto){
    return  userService.verifyUser(requestDto.getEmail(),requestDto.getPassword());
}

}
