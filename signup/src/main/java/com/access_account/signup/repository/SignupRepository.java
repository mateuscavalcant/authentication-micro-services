package com.access_account.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.access_account.signup.model.SignupModel;

public interface SignupRepository extends  JpaRepository<SignupModel, Long>{
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    
}
