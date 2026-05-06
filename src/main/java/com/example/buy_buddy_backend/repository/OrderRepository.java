package com.example.buy_buddy_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.buy_buddy_backend.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
