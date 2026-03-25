package com.example.auth.api.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SaveSecureUserData {
    
    @Autowired
    public UserRepo userRepo;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public void saveUserData(User user) {

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepo.save(user);
    }
}
