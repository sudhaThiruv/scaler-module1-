package dev.naman.mcproductservice.controllers;

import dev.naman.mcproductservice.Models.Product;
import dev.naman.mcproductservice.dtos.CreateProductRequestDto;
import dev.naman.mcproductservice.dtos.GetProductDetailsRequestDTO;
import dev.naman.mcproductservice.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProductController {

    private ProductService productService;
    public  ProductController(ProductService productService){
        this.productService=productService;
    }
@GetMapping("/products/{productId}")
    Product getProductDetails(@PathVariable("productId") Long productId ,@RequestBody GetProductDetailsRequestDTO
        request){
         Product product=productService.getProductDetails(productId, request.getEmail(),request.getPassword());
         return  product;
    }
@PostMapping("/products")
    Product createProduct(@RequestBody CreateProductRequestDto requestDto){
        Product product1=productService.createProduct(requestDto.getProduct(),requestDto.getEmail(),requestDto.getPassword());
        return  product1;
    }

}
