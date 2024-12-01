package com.example.google_api.controller;

import com.example.google_api.service.GoogleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/googleauth")
public class GoogleAuthController {

    @Autowired
    private GoogleAuthService googleAuthService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String email, @RequestParam String name) {
        return googleAuthService.registerUser(email, name);
    }

    @GetMapping("/login")
    public boolean login(@RequestParam String email) {
        return googleAuthService.authenticate(email);
    }
}
