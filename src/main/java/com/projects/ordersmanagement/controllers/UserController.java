package com.projects.ordersmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.ordersmanagement.domain.user.User;
import com.projects.ordersmanagement.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
 
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findALl() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User u = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User u) {
        u = userService.insertUser(u);
        return ResponseEntity.status(HttpStatus.CREATED).body(u);
    }

    @PutMapping
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User u) {
        userService.updateUser(id, u);
        return ResponseEntity.status(HttpStatus.OK).body(u);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
}