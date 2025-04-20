package com.example.userAuthenticationServices.userAuthenticationServices.exceptions;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }
}
