package org.scaler.product.productservice.repo;

import org.scaler.product.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    @Override
    Optional<Category> findById(Long aLong);
}
