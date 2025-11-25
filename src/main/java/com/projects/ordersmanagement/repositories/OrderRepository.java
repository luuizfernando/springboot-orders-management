package com.projects.ordersmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.ordersmanagement.domain.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    
}