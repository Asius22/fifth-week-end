package com.corso.java.esercizi.spring.service.api;

import com.corso.java.esercizi.spring.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(String id);

    List<Product> findByType (String type);

    List<Product> findByPrice(double price);

    Product createProduct(Product p);

    boolean deleteProduct(Product p);
}
