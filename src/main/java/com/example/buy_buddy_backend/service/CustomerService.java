package com.example.buy_buddy_backend.service;

import java.util.List;

import com.example.buy_buddy_backend.model.Customer;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customerDetails);
    void deleteCustomer(Long id);
}
