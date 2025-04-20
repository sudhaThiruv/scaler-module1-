package org.scaler.product.productservice.dtos;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class SearchRequestDto {

    private String query;
    private  Integer   pageSize;
    private Integer pageNumber;



    private List<SortParam> sortParam=new ArrayList<>();


}
