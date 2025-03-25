package com.example.website.controller;

import com.example.website.model.User;
import com.example.website.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://myspringboot-9.onrender.com") // Allow frontend requests
@RestController  // Defines this as a REST API controller
@RequestMapping("/api/users")  // API will be available at http://localhost:8080/api/users
public class UserController {

    @Autowired
    private UserService userService;

    // Fetch all users
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}
