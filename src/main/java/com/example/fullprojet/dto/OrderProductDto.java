package com.example.fullprojet.dto;

import com.example.fullprojet.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderProductDto {
    private Product product;
    private Integer quantity;
}
