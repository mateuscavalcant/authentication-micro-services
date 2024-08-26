package com.access_account.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.access_account.signup.model.SignupModel;
import com.access_account.signup.repository.SignupRepository;


@Service
public class UserSignupService {
    private final SignupRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserSignupService(SignupRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SignupModel signup(SignupModel userSignup) throws Exception {
        if (userRepository.existsByEmail(userSignup.getEmail())) {
            throw new Exception("Email já está em uso.");
        }
        if (userRepository.existsByUsername(userSignup.getUsername())) {
            throw new Exception("Nome de usuário já está em uso.");
        }
        String encodedPassword = passwordEncoder.encode(userSignup.getPassword());
        SignupModel user = new SignupModel(userSignup.getID(), userSignup.getName(), userSignup.getUsername(), userSignup.getEmail(), encodedPassword);
        return userRepository.save(user);
    }

    
}