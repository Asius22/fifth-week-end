package com.corso.java.esercizi.spring.repository;

import com.corso.java.esercizi.spring.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query ("select p from Product p where p.tipo = ?1")
    List<Product> findByType(String tipo);

    @Query ("select p from Product p where p.prezzo <= ?1")
    List<Product> findByPrice(double price);
}
