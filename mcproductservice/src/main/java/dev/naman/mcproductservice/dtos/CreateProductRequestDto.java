package dev.naman.mcproductservice.dtos;

import dev.naman.mcproductservice.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private Product product;
    private  String email;
    private String password;
}
