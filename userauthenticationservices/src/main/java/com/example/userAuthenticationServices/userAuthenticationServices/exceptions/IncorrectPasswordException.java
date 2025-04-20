package com.example.userAuthenticationServices.userAuthenticationServices.exceptions;

public class IncorrectPasswordException extends  RuntimeException{

    public  IncorrectPasswordException(String message){
        super(message);
    }
}
