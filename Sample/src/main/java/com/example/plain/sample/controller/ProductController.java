package com.example.plain.sample.controller;

import com.example.plain.sample.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products/{id}")
    public Product getProductById( @PathVariable Long id){
        Product product=new Product();
        product.setId(id);
        return  product;
    }
}
