package com.projects.ordersmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.ordersmanagement.domain.user.User;
import com.projects.ordersmanagement.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public User insertUser(User user) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public User updateUser(Long id, User u) {
        try {
            User user = repository.findById(id).orElse(null);
            updateData(user, u);
            return repository.save(user);
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