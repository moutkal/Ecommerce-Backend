package com.example.fullprojet.service;

import com.example.fullprojet.entities.Order;

public interface OrderService {
    Iterable<Order> getAllOrders();
    Order create(Order order);
    void update(Order order);
}
