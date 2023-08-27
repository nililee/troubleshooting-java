package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(String name) {
        Product p = new Product();
        p.setId(UUID.randomUUID().toString());
        p.setName(name);
        productRepository.save(p);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
