package com.example.oathuService.oathuService.service;


import com.example.oathuService.oathuService.models.User;
import org.antlr.v4.runtime.misc.Pair;

public interface IAuthService {
    User signup(String email, String password);
    Pair<User, String> login(String email, String password);
    Boolean validateToken(String token,Long userId);
}
