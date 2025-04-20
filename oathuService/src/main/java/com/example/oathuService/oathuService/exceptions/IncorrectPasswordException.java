package com.example.oathuService.oathuService.exceptions;

public class IncorrectPasswordException extends  RuntimeException{
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
