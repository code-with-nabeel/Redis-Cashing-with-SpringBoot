package com.example.buy_buddy_backend.service.implementation;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buy_buddy_backend.dto.OrderRequest;
import com.example.buy_buddy_backend.exception.ResourceNotFoundException;
import com.example.buy_buddy_backend.model.Customer;
import com.example.buy_buddy_backend.model.Order;
import com.example.buy_buddy_backend.model.Product;
import com.example.buy_buddy_backend.repository.CustomerRepository;
import com.example.buy_buddy_backend.repository.OrderRepository;
import com.example.buy_buddy_backend.repository.ProductRepository;
import com.example.buy_buddy_backend.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    @Override
    public Order createOrder(OrderRequest orderRequest) {
        Customer customer = customerRepository.findById(orderRequest.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + orderRequest.getCustomerId()));
        List<Product> products = productRepository.findAllById(orderRequest.getProductIds());
        
        if (products.size() != orderRequest.getProductIds().size()) {
            throw new ResourceNotFoundException("One or more products not found");
        }

        Order order = new Order();

        order.setCustomer(customer);
        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = getOrderById(id);
        orderRepository.delete(order);
    }
}