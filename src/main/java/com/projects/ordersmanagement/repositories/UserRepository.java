package com.projects.ordersmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.ordersmanagement.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}