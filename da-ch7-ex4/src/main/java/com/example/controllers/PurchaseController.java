package com.example.controllers;

import com.example.services.PurchaseService;
import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/products")
    public Set<String> findPurchasedProductNames() {
        return purchaseService.getProductNamesForPurchases();
    }
}
