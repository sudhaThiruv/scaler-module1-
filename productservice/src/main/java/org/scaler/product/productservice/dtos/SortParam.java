package org.scaler.product.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortParam {
    private  String paramName;
    private  SortType sortType;
}
