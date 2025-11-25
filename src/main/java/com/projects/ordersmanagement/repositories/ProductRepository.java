package com.projects.ordersmanagement.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.ordersmanagement.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    
}