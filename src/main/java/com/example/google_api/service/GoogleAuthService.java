package com.example.google_api.service;

import com.example.google_api.entity.GoogleUser;
import com.example.google_api.repository.GoogleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GoogleAuthService {
    @Autowired
    private GoogleUserRepository googleUserRepository;

    public String registerUser(String email, String name) {
        Optional<GoogleUser> existingUser = googleUserRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User already registered with email: " + email);
        }
        GoogleUser user = new GoogleUser();
        user.setEmail(email);
        user.setName(name);
        googleUserRepository.save(user);
        return "User registered successfully!";
    }

    public boolean authenticate(String email) {
        return googleUserRepository.findByEmail(email).isPresent();
    }
}

