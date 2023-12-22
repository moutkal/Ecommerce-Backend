package com.example.fullprojet.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class OrderProductPK {
    //la clé étrangère peut être nulle. Si optional est false, cela signifie que la clé étrangère ne peut pas être nulle.
    //FetchType.LAZY signifie que les données de l'entité cible ne seront chargées depuis la base de données que lorsque vous accéderez explicitement à la relation.
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
