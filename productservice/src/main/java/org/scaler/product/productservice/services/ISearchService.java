package org.scaler.product.productservice.services;


import org.scaler.product.productservice.dtos.SortParam;
import org.scaler.product.productservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {

    Page<Product> searcgProducts(String query, Integer pageNumber, Integer pageSize, List<SortParam> sortParams);
}
