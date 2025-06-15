package com.example.multi_lang.service;

import com.example.multi_lang.dto.AuthenticationRequest;
import com.example.multi_lang.entity.User;
import com.example.multi_lang.repository.UserRepository;
import com.example.multi_lang.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public ResponseEntity<?> authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getPhoneNumber(),
                        authenticationRequest.getPassword()
                )
        );

        Optional<User> userOptional = userRepository.findByPhoneNumber(authenticationRequest.getPhoneNumber());

        if (userOptional.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");

        User user = userOptional.get();

        return ResponseEntity.ok(jwtService.generateToken(user));
    }
}
