package com.example.buy_buddy_backend.service;

import java.util.List;

import com.example.buy_buddy_backend.model.Product;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product productDetails);
    void deleteProduct(Long id);
}
