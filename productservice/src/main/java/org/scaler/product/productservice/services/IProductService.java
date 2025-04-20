package org.scaler.product.productservice.services;

import org.scaler.product.productservice.models.Product;

import java.util.List;

public interface IProductService {
    Product getProductById(Long id);
    List<Product> getAllproducts();
    Product replaceProduct(Product product,Long id);
    Boolean deleteProduct(Long id);
    Product createProduct(Product product);


}

