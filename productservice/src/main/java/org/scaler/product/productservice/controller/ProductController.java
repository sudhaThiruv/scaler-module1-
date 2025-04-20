package org.scaler.product.productservice.controller;

import org.scaler.product.productservice.dtos.CategoryDto;
import org.scaler.product.productservice.dtos.ProductDto;
import org.scaler.product.productservice.models.Category;
import org.scaler.product.productservice.models.Product;
import org.scaler.product.productservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
   // @Qualifier("sps")
    private IProductService productService;


    @GetMapping
    public List<ProductDto> getAllProducts() {
        List<Product> products=productService.getAllproducts();

        List<ProductDto> productDtos=new ArrayList<>();
        for(Product product:products){
            productDtos.add(from(product));
        }
       return productDtos;
    }

    @GetMapping("/{id}")
    public ProductDto getProductDetails(@PathVariable Long id) {
        if(id < 0) {
            throw new IllegalArgumentException("Please pass productId greater than 0");
        }else if(id == 0) {
            throw new IllegalArgumentException("Please pass positive productId");
        }
        //id++;
        Product product = productService.getProductById(id);
        if(product == null) return null;
        return from(product);
    }
@PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto){
    Product input=from(productDto);
    Product response=productService.createProduct(input);
    return from(response);
    }
    @PutMapping("/{id}")
    public ProductDto replaceProduct(@PathVariable Long id,
                                     @RequestBody ProductDto productDto) {
        Product input=from(productDto);
        Product product=productService.replaceProduct(input,id) ;

        if(product ==null) return  null;

        return from(product);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteProduct(@PathVariable Long id) {
        return null;
    }

    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }

    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setId(productDto.getId());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageUrl());
        product.setPrice(productDto.getPrice());
        if(productDto.getCategory() != null) {
            Category category = new Category();
            category.setName(productDto.getCategory().getName());
            category.setId(productDto.getCategory().getId());
            category.setDescription(productDto.getCategory().getDescription());
            product.setCategory(category);
        }
        return  product;
    }
}
