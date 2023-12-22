package com.example.fullprojet.service;

import com.example.fullprojet.entities.OrderProduct;
import com.example.fullprojet.repository.OrderProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderProductServiceImpl implements OrderProductService{

    private OrderProductRepository orderProductRepository;
    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
