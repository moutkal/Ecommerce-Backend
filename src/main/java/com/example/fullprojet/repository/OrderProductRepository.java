package com.example.fullprojet.repository;

import com.example.fullprojet.entities.OrderProduct;
import com.example.fullprojet.entities.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}
