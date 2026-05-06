package com.example.buy_buddy_backend.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buy_buddy_backend.exception.ResourceNotFoundException;
import com.example.buy_buddy_backend.model.Customer;
import com.example.buy_buddy_backend.repository.CustomerRepository;
import com.example.buy_buddy_backend.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer customerDetails) {
        Customer customer = getCustomerById(id);
        customer.setName(customerDetails.getName());
        customer.setEmail(customerDetails.getEmail());
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer = getCustomerById(id);
        customerRepository.delete(customer);
    }
}