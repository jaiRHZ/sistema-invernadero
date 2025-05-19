package com.microservice.auth.controller;

import com.microservice.auth.model.User;
import com.microservice.auth.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Date;


@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Clave secreta para firmar el token
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Usuario ya existe";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "Usuario registrado exitosamente";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            // Generar el token JWT
            String jwt = Jwts.builder()
        .setSubject(existingUser.getUsername())
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
        .signWith(rsaPrivateKey, SignatureAlgorithm.RS256)  // Usar RS256 si es RSA
        .compact();
            return jwt; // Devolver el token generado
        }
        return "Credenciales incorrectas";
    }


    public Key getKey() {
        return key;
    }
}