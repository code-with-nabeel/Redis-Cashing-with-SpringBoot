package com.example.buy_buddy_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Double price;
}
