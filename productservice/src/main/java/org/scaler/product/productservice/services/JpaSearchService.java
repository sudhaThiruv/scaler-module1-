package org.scaler.product.productservice.services;

import org.scaler.product.productservice.dtos.SortParam;
import org.scaler.product.productservice.dtos.SortType;
import org.scaler.product.productservice.models.Product;
import org.scaler.product.productservice.repo.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaSearchService implements ISearchService{
    @Autowired
    ProductRepo productRepo;

    @Override
    public Page<Product> searcgProducts(String query, Integer pageNumber, Integer pageSize, List<SortParam> sortParams) {

        Sort sort=null;

        if(!sortParams.isEmpty()){
            if(sortParams.get(0).getSortType().equals(SortType.ASC))

                sort=Sort.by(sortParams.get(0).getParamName());
            else
                sort=Sort.by(sortParams.get(0).getParamName()).descending();


        }
        for(int i=1;i<sortParams.size();i++) {
            if(sortParams.get(i).getSortType().equals(SortType.ASC))
                sort = sort.and(Sort.by(sortParams.get(i).getParamName()));
            else
                sort = sort.and(Sort.by(sortParams.get(i).getParamName()).descending());
        }

        Page<Product> products = productRepo.findByNameEquals(query,
                PageRequest.of(pageNumber,pageSize,sort));
        return products;



    }
}
