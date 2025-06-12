package com.example.demoforrohit.services;

import com.example.demoforrohit.Entity.User;
import com.example.demoforrohit.JPA.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        return userOpt.isPresent() && userOpt.get().getPassword().equals(password);
    }

    public boolean userExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    public User register(User user) {
        user.setId(null); // Ensure a new user is created
        return userRepository.save(user);
    }
}
