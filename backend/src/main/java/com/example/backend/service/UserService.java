package com.example.backend.service;

import org.springframework.stereotype.Service;

import java.util.Map;

// UserService.java
@Service
public class UserService {

    private final Map<String, String> users = Map.of(
            "tobi", "pass123",
            "mama", "kc",
            "papa", "traktor789",
            "oma", "kekse999"
    );

    public boolean isValidUser(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}

