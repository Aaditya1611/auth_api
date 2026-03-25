package com.example.auth.api.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.api.jwt.JwtService;
import com.example.auth.api.signup.User;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class LoginController {
    
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Autowired
    public JwtService jwtService;


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {

        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        
                UserDetailsImplementation userDetails = (UserDetailsImplementation) authentication.getPrincipal();

                Map<String, Object> response = new HashMap<>();
                response.put("generated token", jwtService.generateToken(user.getUsername()));

                return ResponseEntity.ok("login successfull" + response);
            } catch (BadCredentialsException e) {
                System.out.println("invalid username or password");
                return ResponseEntity.status(401).body("invalid username or password");
            }
    }
}
