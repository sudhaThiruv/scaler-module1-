package com.example.oathuService.oathuService.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ValidateTokenDto {
    String token;
    Long userId;
}