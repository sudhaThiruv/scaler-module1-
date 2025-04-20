package com.example.userAuthenticationServices.userAuthenticationServices.service;

import com.example.userAuthenticationServices.userAuthenticationServices.exceptions.IncorrectPasswordException;
import com.example.userAuthenticationServices.userAuthenticationServices.exceptions.UserAlreadyExistException;
import com.example.userAuthenticationServices.userAuthenticationServices.exceptions.UserNotFoundException;
import com.example.userAuthenticationServices.userAuthenticationServices.models.User;
import com.example.userAuthenticationServices.userAuthenticationServices.repo.UserRepo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;
import org.antlr.v4.runtime.misc.Pair;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public User signup(String email, String password) {
        Optional<User> userOptional = userRepo.findUserByEmailId(email);
        if(userOptional.isPresent()) {
            throw new UserAlreadyExistException("Please try login.");
        }

        User user = new User();
        user.setEmailId(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

       // user.setId(new Random().nextLong());
        return userRepo.save(user);
    }

    /*
    @Override
    public Pair<User,String> login(String email, String password) {
        Optional<User> userOptional = userRepo.findUserByEmailId(email);
        if(userOptional.isEmpty()) {
            throw new UserNotFoundException("Please signup first");
        }

        String storedPassword = userOptional.get().getPassword();

        if(!bCryptPasswordEncoder.matches(password,storedPassword)) {
            throw new IncorrectPasswordException("Please pass correct password, otherwise reset your password");
        }

        //Generating Token
//        String message = "{\n" +
//                "   \"email\": \"anurag@gmail.com\",\n" +
//                "   \"roles\": [\n" +
//                "      \"instructor\",\n" +
//                "      \"buddy\"\n" +
//                "   ],\n" +
//                "   \"expirationDate\": \"2ndApril2025\"\n" + "}";
//
//        byte[] content = message.getBytes(StandardCharsets.UTF_8);

        Map<String,Object> payload = new HashMap<>();
        payload.put("userId",userOptional.get().getId());
        Long currentTime = System.currentTimeMillis();
        payload.put("iat",currentTime);
        payload.put("exp",currentTime+100000);
        payload.put("iss","scaler");

//        MacAlgorithm algorithm = Jwts.SIG.HS256;
//        SecretKey secretKey = algorithm.key().build();

        String token = Jwts.builder().claims(payload).signWith(secretKey).compact();
        return new Pair<User,String>(userOptional.get(),token);
    }

    //Alternative Implementation Commit - https://github.com/ak-s-0723/UserAuthService_Dec2024/commit/bb2a903fabb0767b641318f3cc27a6ff735692c6
    public Boolean validateToken(String token,Long userId) {
        try {
            JwtParser jwtParser = Jwts.parser().verifyWith(secretKey).build();
            Claims claims = jwtParser.parseSignedClaims(token).getPayload();

            String newToken = Jwts.builder().claims(claims).signWith(secretKey).compact();
            if (!token.equals(newToken)) {
                System.out.println(newToken);
                System.out.println(token);
                System.out.println("Invalid Token");
                throw new RuntimeException("Invalid Token");
            }

            Long expiry = (Long)claims.get("exp");
            Long currentTime = System.currentTimeMillis();
            if(currentTime > expiry) {
                System.out.println("Token has expired");
                throw new RuntimeException("Token has expired");
            }

            return true;
        }catch (Exception exception) {
            throw exception;
        }
    }
    /*
     */


}
