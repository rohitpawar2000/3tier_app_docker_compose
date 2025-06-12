package com.example.demoforrohit.controller;

import com.example.demoforrohit.Entity.User;
import com.example.demoforrohit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (!userService.userExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("User not registered. Please register first.");
        }
        boolean authenticated = userService.authenticate(user.getUsername(), user.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Username must not be null or empty");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Password must not be null or empty");
        }
        if (userService.userExists(user.getUsername())) {
            return ResponseEntity.badRequest().body("User already registered");
        }
        userService.register(user);
        return ResponseEntity.ok("Registration successful");
    }
}
