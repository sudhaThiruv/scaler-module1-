package bofa.org.controller;

import bofa.org.dtos.ProductDto;
import bofa.org.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

        @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable Long id){
        Product product=new Product();
        product.setId(id);
        product.setName("Iphone 15");
        return  product;
    }

    @GetMapping("/products")
    public List<ProductDto> getAllProducts(){
        return  null;
    }

    @PutMapping("/products/{id}")
    public ProductDto replaceProduct(@PathVariable Long id,
                                     @RequestBody ProductDto productDto){
        return  null;
    }
}
