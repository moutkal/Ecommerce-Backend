package com.example.fullprojet;

import com.example.fullprojet.entities.Product;
import com.example.fullprojet.repository.ProductRepository;
import com.example.fullprojet.service.IPservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FullProjetApplication implements CommandLineRunner {
    @Autowired
    private IPservice iPservice;
    public static void main(String[] args) {
        SpringApplication.run(FullProjetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        iPservice.save(new  Product(null, "TV Set", 300.00, "http://placehold.it/200x100") );
    }
}
