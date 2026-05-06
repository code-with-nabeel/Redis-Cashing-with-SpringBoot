package com.example.buy_buddy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.buy_buddy_backend.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
