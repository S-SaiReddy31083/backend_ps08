package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // SIGNUP
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            return "Email already exists";
        }

        userRepository.save(user);
        return "Signup successful";
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User loginUser) {

        User user = userRepository.findByEmail(loginUser.getEmail());

        if (user != null && user.getPassword().equals(loginUser.getPassword())) {
            return user;
        }

        return null;
    }
}
