package com.example.buy_buddy_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "customer_name")
    private String name;
    private String email;
}
