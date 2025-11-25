package com.projects.ordersmanagement.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.ordersmanagement.domain.product.Product;
import com.projects.ordersmanagement.repositories.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Product insertProduct(Product p) {
        return repository.save(p);
    }

    public void deleteProduct(UUID id) {
        repository.deleteById(id);
    }

    public Product updateProduct(UUID id, Product p) {
        try {
            Product product = repository.findById(id).orElse(null);
            updateData(product, p);
            return repository.save(p);
        } catch (Exception e) {
            throw new RuntimeException("Error updating user", e);
        }
    }

    private void updateData(Product prod, Product p) {
        prod.setName(p.getName());
        prod.setDescription(p.getDescription());
        prod.setQuantity(p.getQuantity());
        prod.setPrice(p.getPrice());
    }

}