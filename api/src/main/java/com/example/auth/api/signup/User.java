package com.example.auth.api.signup;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity; 
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @Id
    private Long id;
    
    private String username;
    private String email;
    private String password;

    
}
