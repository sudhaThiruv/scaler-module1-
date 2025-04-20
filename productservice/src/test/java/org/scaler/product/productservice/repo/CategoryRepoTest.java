package org.scaler.product.productservice.repo;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.scaler.product.productservice.models.Category;
import org.scaler.product.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;
    @Test
    @Transactional
    public void testFetchTypes() {
        Category category = categoryRepo.findById(2L).get();
        System.out.println(category.getName());
//        for(Product product : category.getProducts()) {
//            System.out.println(product.getName());
//        }
    }


    //BatchSize with Select is better answer than subselect for N+1 Problem
    @Test
    @Transactional
    public void testSomething() {
        List<Category> categoryList = categoryRepo.findAll();
        for(Category category : categoryList) {
            for(Product product : category.getProducts()) {
                System.out.println(product.getName());
            }
        }
    }
}
