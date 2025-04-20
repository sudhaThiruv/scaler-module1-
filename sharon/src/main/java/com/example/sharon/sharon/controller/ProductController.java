package com.example.sharon.sharon.controller;

import com.example.sharon.sharon.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id){
        Product product=new Product();
        product.setId(id);
        product.setName("Iphone");
        return  product;

    }
}
