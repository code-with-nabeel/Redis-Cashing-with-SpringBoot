package com.example.buy_buddy_backend.service;

import java.util.List;

import com.example.buy_buddy_backend.dto.OrderRequest;
import com.example.buy_buddy_backend.model.Order;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(OrderRequest orderRequest);
    void deleteOrder(Long id);
}
