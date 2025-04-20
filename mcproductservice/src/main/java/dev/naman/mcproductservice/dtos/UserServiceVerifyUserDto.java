package dev.naman.mcproductservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceVerifyUserDto {
    private  String email;
    private  String password;
}
