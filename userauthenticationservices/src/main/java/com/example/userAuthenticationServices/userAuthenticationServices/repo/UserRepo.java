package com.example.userAuthenticationServices.userAuthenticationServices.repo;

import com.example.userAuthenticationServices.userAuthenticationServices.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    Optional<User> findUserByEmailId(String emailId);
}
