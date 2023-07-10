package com.GreenStitch.UserAuthentication.service;

import com.GreenStitch.UserAuthentication.dao.UserRepository;
import com.GreenStitch.UserAuthentication.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User signup(User user) {
        // Check if username already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        // Encrypt the password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Save the user
        return userRepository.save(user);
    }

    public String login(String username, String password) {
        // Retrieve the user from the database
        User user = userRepository.findByUsername(username);

        // Validate credentials
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        // Generate and return the JWT token
        String token = generateJwtToken(user);
        return token;
    }

    private String generateJwtToken(User user) {
        // Generate JWT token using your preferred library (e.g., jjwt)

        // Example using jjwt library
        String token = Jwts.builder()
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS256, "your-secret-key")
                .compact();

        return token;
    }
}
