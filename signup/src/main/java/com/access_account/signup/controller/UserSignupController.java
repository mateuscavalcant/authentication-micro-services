package com.access_account.signup.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.access_account.signup.model.SignupModel;
import com.access_account.signup.service.UserSignupService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8081")
public class UserSignupController {
    private final UserSignupService userServiceSignup;


    @Autowired
    public UserSignupController(UserSignupService userServiceSignup) {
        this.userServiceSignup = userServiceSignup;
    }


@PostMapping("/signup")
public ResponseEntity<Map<String, String>> signup(@RequestBody SignupModel userSignup) {
    Map<String, String> response = new HashMap<>();
    try {
        userServiceSignup.signup(userSignup);
        response.put("message", "Usuário registrado com sucesso.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    } catch (Exception e) {
        response.put("error", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
}
