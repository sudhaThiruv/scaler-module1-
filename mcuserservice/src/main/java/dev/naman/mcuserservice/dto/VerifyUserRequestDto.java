package dev.naman.mcuserservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyUserRequestDto {
    private String email;
    private  String password;
}
