package com.example.fullprojet.service;

import com.example.fullprojet.entities.OrderProduct;

public interface OrderProductService {
    OrderProduct create(OrderProduct orderProduct);
    //    OrderProduct create(@NotNull(message = "The products for order cannot be null.") @Valid OrderProduct orderProduct);
}
