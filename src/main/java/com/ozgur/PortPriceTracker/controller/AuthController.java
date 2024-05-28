package com.ozgur.PortPriceTracker.controller;

import com.ozgur.PortPriceTracker.config.JwtUtils;
import com.ozgur.PortPriceTracker.entities.User;
import com.ozgur.PortPriceTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            String jwt = jwtUtils.generateJwtToken(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            Map<String, Object> response = new HashMap<>();
            response.put("token", jwt);
            response.put("roles", authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()));
            response.put("message", "Login successful");

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            e.printStackTrace(); // Log the exception
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> register(@RequestBody AuthRequest authRequest) {
        if (userRepository.existsByUsername(authRequest.getUsername())) {
            return ResponseEntity.status(400).body("User already exists");
        }

        User user = new User();
        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
    }

    public static class AuthRequest {
        private String username;
        private String password;

        // getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
