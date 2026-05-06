package com.example.buy_buddy_backend.service.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.example.buy_buddy_backend.exception.ResourceNotFoundException;
import com.example.buy_buddy_backend.model.Product;
import com.example.buy_buddy_backend.repository.ProductRepository;
import com.example.buy_buddy_backend.service.ProductService;
import org.springframework.cache.annotation.Cacheable;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    @Override
    @Cacheable(value = "products" )
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    @CachePut(value = "products",key = "#id")
    public Product updateProduct(Long id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    @Override
    @CacheEvict(value = "products" ,key = "#id")
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not exits with ID " + id));
        productRepository.delete(product);

    }
}