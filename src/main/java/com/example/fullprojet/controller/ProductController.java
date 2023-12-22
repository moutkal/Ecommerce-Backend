package com.example.fullprojet.controller;

import com.example.fullprojet.entities.Product;
import com.example.fullprojet.repository.ProductRepository;
import com.example.fullprojet.service.IPservice;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {
    private final IPservice iPservice;

    @GetMapping("/")
    public Iterable<Product> getAllProducts(){
        return iPservice.getAllProducts();
    }

}
