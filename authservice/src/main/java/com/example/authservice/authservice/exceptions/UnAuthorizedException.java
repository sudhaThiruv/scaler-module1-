package com.example.authservice.authservice.exceptions;

public class UnAuthorizedException extends  RuntimeException{
    public  UnAuthorizedException(String message){
    super(message);
    }
}
