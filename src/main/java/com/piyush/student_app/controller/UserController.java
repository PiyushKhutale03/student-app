package com.piyush.student_app.controller;


import com.piyush.student_app.service.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.student_app.model.User;
import com.piyush.student_app.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("register")
    public User register(@Valid @RequestBody User user) {
        return service.saveUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
            if(authentication.isAuthenticated()) {
                return ResponseEntity.ok(jwtService.generateToken(user.getUsername()));
            }
            return ResponseEntity.status(401).body("Login Failed!");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid Credentials!"); // ✅
        }
    }
}
