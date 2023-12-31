package com.example.controllers;

import com.example.model.Product;
import com.example.services.RandomProductsService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomProductsController {

    private final RandomProductsService randomProductsService;

    public RandomProductsController(RandomProductsService randomProductsService) {
        this.randomProductsService = randomProductsService;
    }

    @GetMapping("/products/{n}")
    public List<Product> getRandomProducts(@PathVariable Integer n) {
        return randomProductsService.getRandomProductsList(n);
    }
}
