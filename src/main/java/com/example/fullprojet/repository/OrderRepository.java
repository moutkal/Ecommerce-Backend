package com.example.fullprojet.repository;

import com.example.fullprojet.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
