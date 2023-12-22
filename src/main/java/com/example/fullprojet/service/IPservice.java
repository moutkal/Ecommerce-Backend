package com.example.fullprojet.service;

import com.example.fullprojet.entities.Product;
import jakarta.persistence.EntityNotFoundException;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.validation.annotation.Validated;


//Lorsque vous utilisez @Validated,Spring va automatiquement valider les arguments des méthodes annotées lors de leur appel.
@Validated
public interface IPservice {

    @NotNull Iterable<Product> getAllProducts();

     Product getProduct(Long id);

     Product save(Product product);

}
