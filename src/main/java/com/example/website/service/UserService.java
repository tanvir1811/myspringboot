package com.example.website.service;

import com.example.website.model.User;
import com.example.website.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();  // Fetch users from database
    }

    public User saveUser(User user) {
        return userRepository.save(user);  // Save user in database
    }
}
