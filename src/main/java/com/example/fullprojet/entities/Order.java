package com.example.fullprojet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "orders")
public class Order {
   @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateCreated;
    private String status;
    @OneToMany(mappedBy = "pk.order")
    private List<OrderProduct> orderProducts= new ArrayList<>();

}
