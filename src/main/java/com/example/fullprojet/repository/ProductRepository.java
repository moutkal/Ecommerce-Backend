package com.example.fullprojet.repository;

import com.example.fullprojet.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {



}
