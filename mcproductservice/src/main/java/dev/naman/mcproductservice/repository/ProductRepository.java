package dev.naman.mcproductservice.repository;

import dev.naman.mcproductservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Product save(Product product);
    //Product getById(Long productId);
    @Override
    Optional<Product> findById(Long along);
}
