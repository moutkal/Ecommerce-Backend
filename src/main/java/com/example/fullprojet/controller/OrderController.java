package com.example.fullprojet.controller;

import com.example.fullprojet.dto.OrderProductDto;
import com.example.fullprojet.entities.Order;
import com.example.fullprojet.entities.OrderProduct;
import com.example.fullprojet.entities.OrderStatus;
import com.example.fullprojet.service.IPservice;
import com.example.fullprojet.service.OrderProductService;
import com.example.fullprojet.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderController {
    private OrderService orderService;
    private OrderProductService orderProductService;
    private IPservice iPservice;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Order> list(){
        return this.orderService.getAllOrders();
    }
    @PostMapping
    public ResponseEntity<Order> create(@RequestBody OrderForm form ){
        List<OrderProductDto> formDtos = form.getProductOrders();
        validateProductsExistence(formDtos);
        Order order = new Order();
        order.setStatus(OrderStatus.PAID.name());
        order = this.orderService.create(order);

        List<OrderProduct> orderProducts = new ArrayList<>();
        for(OrderProductDto dto : formDtos){
            orderProducts.add(orderProductService.create( new OrderProduct(
                 order,iPservice.getProduct(dto.getProduct().getId()), dto.getQuantity()
            )));
        }

        order.setOrderProducts(orderProducts);
        this.orderService.update(order);


        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    private void validateProductsExistence(List<OrderProductDto> orderProducts){
       //Stream API vous permet d'effectuer diverses opérations sur une collection, comme la filtration, la transformation, le tri, etc.
        List<OrderProductDto> list = orderProducts.stream().filter(op -> Objects.isNull(iPservice.getProduct(op
                        .getProduct()
                        .getId()))).collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(list)) {
            throw new EntityNotFoundException("Product not found");
        }

    }

    @AllArgsConstructor @Data @NoArgsConstructor
    public static class OrderForm {

        private List<OrderProductDto> productOrders;


    }
}
