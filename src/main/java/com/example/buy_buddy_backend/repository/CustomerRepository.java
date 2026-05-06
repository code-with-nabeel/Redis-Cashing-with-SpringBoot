package com.example.buy_buddy_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.buy_buddy_backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Custom query method
    List<Customer> findByEmail(String email);
}