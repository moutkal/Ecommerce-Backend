package com.example.fullprojet.service;

import com.example.fullprojet.entities.Product;
import com.example.fullprojet.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
//@Slf4j pour l'activation de journalisation
public class ProductServiceImpl implements IPservice  {

    private final ProductRepository productRepository;


    @Override
    public Iterable<Product> getAllProducts() {

            return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return  productRepository.save(product);
    }
}



