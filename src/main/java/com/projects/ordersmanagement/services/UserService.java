package com.projects.ordersmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.ordersmanagement.domain.user.User;
import com.projects.ordersmanagement.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User u) {
        try {
            User user = userRepository.findById(id).orElse(null);
            updateData(user, u);
            return userRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
    }

    private void updateData(User user, User u) {
        user.setUsername(u.getUsername());
        user.setEmail(u.getEmail());
        user.setPassword(u.getPassword());
        user.setRole(u.getRole());
    }

}