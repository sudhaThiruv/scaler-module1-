package org.scaler.product.productservice.repo;

import org.scaler.product.productservice.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    Product save(Product product);
    Page<Product> findByNameEquals(String name, Pageable pageable);

    @Override
    Optional<Product> findById(Long id);
}
