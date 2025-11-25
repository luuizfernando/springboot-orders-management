package com.projects.ordersmanagement.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.projects.ordersmanagement.domain.product.Product;
import com.projects.ordersmanagement.services.ProductService;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController("/products")
public class ProductController {
    
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable UUID id) {
        Product p = service.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(p);
    }

}