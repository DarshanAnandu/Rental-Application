package com.olik.backend.service;

import com.olik.backend.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAvailableProducts(LocalDate searchData) {
        return productRepository.findAvailableProducts(searchData);
    }
}
