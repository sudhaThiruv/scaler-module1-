package com.example.userAuthenticationServices.userAuthenticationServices.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity

public class User extends BaseModel{
    private String emailId;
    private String password;
}

