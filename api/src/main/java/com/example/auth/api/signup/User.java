package com.example.auth.api.signup;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String username;
    private String email;
    private String password;


    
}
