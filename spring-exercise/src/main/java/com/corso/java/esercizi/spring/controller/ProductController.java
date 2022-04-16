package com.corso.java.esercizi.spring.controller;

import com.corso.java.esercizi.spring.domain.Product;
import com.corso.java.esercizi.spring.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(
                productService.findAll()
        );
    }

    @GetMapping(path = "/id")
    public ResponseEntity<Product> getById(@RequestParam String id){
        return ResponseEntity.ok(
                productService.findById(id)
        );
    }

    @GetMapping(path = "/getType")
    public ResponseEntity<List<Product>> getByType(@RequestParam String type){
        return ResponseEntity.ok(
                productService.findByType(type)
        );
    }

    @GetMapping(path = "/getPrice")
    public ResponseEntity<List<Product>> getByPrice(@RequestParam double price){
        return ResponseEntity.ok(
                productService.findByPrice(price)
        );
    }

    @PostMapping(path = "/")
    public ResponseEntity<Product> saveProduct(@RequestBody Product p){
        return ResponseEntity.ok(
                productService.createProduct(p)
        );
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<String> deleteProduct(@RequestBody Product p){
        return ResponseEntity.ok(
                (productService.deleteProduct(p)) ?
                        "Prodotto eliminato con successo" :
                        "Qualcosa è andato storto"
        );
    }
}
