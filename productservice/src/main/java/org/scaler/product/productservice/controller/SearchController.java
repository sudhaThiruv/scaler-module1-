package org.scaler.product.productservice.controller;

import org.scaler.product.productservice.dtos.SearchRequestDto;
import org.scaler.product.productservice.models.Product;
import org.scaler.product.productservice.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Autowired
    private ISearchService searchService;

    @PostMapping("/search")
    public Page<Product> searchProduct(@RequestBody SearchRequestDto searchRequestDto){
         return searchService.searcgProducts(searchRequestDto.getQuery(),
                searchRequestDto.getPageNumber(),
                searchRequestDto.getPageSize(),
                searchRequestDto.getSortParam());

    }
}
