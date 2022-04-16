package com.corso.java.esercizi.spring.service;

import com.corso.java.esercizi.spring.domain.Product;
import com.corso.java.esercizi.spring.repository.ProductRepository;
import com.corso.java.esercizi.spring.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(String id) {
        try {
            return productRepository.findById(id).orElseThrow();
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<Product> findByType(String type) {
        return productRepository.findByType(type);
    }

    @Override
    public List<Product> findByPrice(double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public Product createProduct(Product p) {
        return productRepository.save(p);
    }

    @Override
    public boolean deleteProduct(Product p) {
        productRepository.delete(p);
        return findAll().contains(p);
    }
}
