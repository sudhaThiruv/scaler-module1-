package com.example.userAuthenticationServices.userAuthenticationServices.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String message){
        super(message);
    }
}
