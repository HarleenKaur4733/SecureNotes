package com.harleen.secure_notes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.harleen.secure_notes.entity.User;
import com.harleen.secure_notes.service.CustomUserDetailsService;
import com.harleen.secure_notes.service.UserService;
import com.harleen.secure_notes.utils.JwtService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // login with jwt token
    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(), user.getPassword()));
        UserDetails userDetails = customUserDetailsService
                .loadUserByUsername(user.getUsername());

        return jwtService.generateToken(userDetails.getUsername());
    }
}
