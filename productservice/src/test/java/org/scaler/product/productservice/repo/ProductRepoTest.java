package org.scaler.product.productservice.repo;

import org.junit.jupiter.api.Test;
import org.scaler.product.productservice.models.Category;
import org.scaler.product.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductRepoTest {
    @Autowired
    private ProductRepo productRepo;

    @Test
    public void insertIntoRDS() {
        Product product = new Product();
        product.setId(1L);
        product.setName("Iphone15");
        product.setPrice(1000000D);
        Category category = new Category();
        category.setId(2L);
        category.setName("Phones");
        product.setCategory(category);
        productRepo.save(product);

        Product product2 = new Product();
        product2.setId(5L);
        product2.setName("Macbook Air");
        product2.setPrice(999999D);
        Category category2 = new Category();
        category2.setId(12L);
        category2.setName("Laptops");
        product2.setCategory(category);
        productRepo.save(product2);
    }


}
