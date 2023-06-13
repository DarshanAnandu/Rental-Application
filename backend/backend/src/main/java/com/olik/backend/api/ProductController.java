package com.olik.backend.api;

import com.olik.backend.model.Product;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> searchProducts(@RequestParam LocalDateTime searchDate) {
        return productService.getAvailableProductss(searchDate);
    }
}
